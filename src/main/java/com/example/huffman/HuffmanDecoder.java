package com.example.huffman;

import java.util.Iterator;
import java.util.Map;

public class HuffmanDecoder {

    /**
     * 代码段对应的代码集
     */
    private Map<String, String> codeSet;

    public HuffmanDecoder(Map<String, String> codeSet) {
        this.codeSet = codeSet;
    }

    /**
     *
     * @param code
     * @return
     */
    public String decode(String code){
        String message = "";
        String key = "";

        char[] chars = code.toCharArray();
        for(int i = 0; i < chars.length; i++){
            key += chars[i];
            if(codeSet.containsValue(key)){
                //代码集中存在该段代码
                Iterator<Map.Entry<String, String>> iterator = codeSet.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry<String, String> entry = iterator.next();
                    if(entry.getValue().equals(key)){
                        //获取该段代码对应的键值，即消息字符
                        message += entry.getKey();
                    }
                }
                key = "";
            }else{
                continue;
            }
        }
        return message;
    }
}
