package com.study.core.utils;

import java.util.*;

/**
 * @author ：Curtain
 * @date ：Created in 2020/8/5 11:34
 * @description：Map工具类
 */
public class MapUtil {

    public static void mapListSort(List<Map<String,String>> list, String key, boolean isAsc){
        Collections.sort(list, new Comparator<Map<String,String>>() {
            @Override
            public int compare(Map o1, Map o2){
                try{
                    if(Integer.parseInt((String)o1.get(key)) > Integer.parseInt((String) o2.get(key))){
                        return  (isAsc) ? 1 : -1;
                    }else if(Integer.parseInt((String)o1.get(key)) < Integer.parseInt((String)o2.get(key))){
                        return (isAsc) ? -1 : 1;
                    }else{
                        return 0;
                    }
                }catch (Exception ex){
                }
                return 0;
            }
        });
    }

    public static void main(String[] args) {
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> o1 = new HashMap<>();
        Map<String,String> o2 = new HashMap<>();
        Map<String,String> o3 = new HashMap<>();
        o1.put("bjjl", "1");o2.put("bjjl", "3");o3.put("bjjl", "2");
        list.add(o1);list.add(o2);list.add(o3);
        mapListSort(list, "bjjl", true);
        System.out.println(list);
    }
}
