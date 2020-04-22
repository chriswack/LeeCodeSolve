package com.wack.code;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {


        List<String> strs = new ArrayList();
        strs.add(null);
        strs.add(null);
        strs.add(null);
        strs.add(null);
        System.out.println(strs.size());

        boolean s = new Character('{') == '{';
        boolean s2 = new Character('{').equals('{') ;
        System.out.println(s);
        System.out.println(s2);
    }

}
