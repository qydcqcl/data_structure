package com.example.huffman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HuffmanEncoder {

    /**
     * 辅助建立霍夫曼树的优先级队列
     */
    private PriorityQueue queue;

    /**
     * 霍夫曼树
     */
    private HuffmanTree tree;

    /**
     * 存储消息文本
     */
    private String[] message;

    /**
     * 存储字符以及词频的对应关系
     */
    private Map<String, Integer> keyMap;

    /**
     * 存储字符以及代码的对应关系
     */
    private Map<String, String> codeSet;

    public HuffmanEncoder() {
        queue = new PriorityQueue();
        keyMap = new HashMap<String,Integer>();
    }

    public String encode(String msg){
        resolveMassage(msg);
        buildCodeSet();
        String code = "";
        //将消息文本的逐个字符翻译成霍夫曼编码
        for(int i = 0; i < message.length; i++){
            code = code + codeSet.get(message[i]);
        }
        return code;
    }

    /**
     * 将一段字符串消息解析成单个字符与该字符词频的对应关系，存入Map
     * @param msg
     */
    private void resolveMassage(String msg) {
        char[] chars = msg.toCharArray();
        message = new String[chars.length];
        for(int i = 0; i < chars.length; i++){
            String key = chars[i] + "";
            message[i] = key;
            if(keyMap.containsKey(key)){
                //如果Map中已存在该字符，则词频加一
                keyMap.put(key, keyMap.get(key) + 1);
            }else{
                keyMap.put(key, 1);
            }
        }
    }

    /**
     * 建立对应某段消息的代码集
     */
    private void buildCodeSet(){
        Iterator<Map.Entry<String, Integer>> iterator = keyMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            //用该字符和该字符的词频为参数，建立一个新的节点，插入优先级队列
            Node node = new Node(entry.getValue(), entry.getKey());
            queue.insert(node);
        }
        queue.display();
        tree = queue.buildHuffmanTree();
        codeSet = tree.getCodeSet();
    }

    /**
     * 打印该段消息的代码集
     */
    public void printCodeSet(){
        Iterator<Map.Entry<String, String>> iterator = codeSet.entrySet().iterator();
        System.out.println("代码集: ");
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + "——>" + entry.getValue());
        }
        System.out.println();
    }

    /**
     * 获取该段消息的代码集
     * @return
     */
    public Map<String, String> getCodeSet(){
        return codeSet;
    }
}
