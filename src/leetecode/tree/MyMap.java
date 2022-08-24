package leetecode.tree;

import java.util.HashMap;

public class MyMap{
    public static void main(String ...args){
        MyMap1 map = new MyMap1();
        map.put("prashant", 1);
        map.put("prashant", 2);
        map.removeKeyValues();
        System.out.println(map);
    }
}
class MyMap1 extends HashMap {

    public MyMap1(){
        super();
    }
    public void removeKeyValues(){
        System.out.println("test method");
    }
}

