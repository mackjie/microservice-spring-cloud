package com.whl.cloud.microservicesimpleprivideruser.JunitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * ListTest
 * TODO:
 * 2018/4/816:37
 * 1.0
 * hlwu
 * 集合底层测试、探究
 * list:底层是一个数组，所以序号从0开始
 */
class CollectTest {

    @Test
    @DisplayName("集合List测试")
    void listTest(){
        List<String> list = new ArrayList();
        list.add("makjie");
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add(0, "曾七");
        list.set(3,"whl");
        list.remove("李四");
        for (String str:list) {
            System.out.println(str);
        }

        //线性链表结构：实现了List接口和Deque接口，栈或队列，现在的首选是ArrayDeque，它有着比LinkedList（当作栈或队列使用时）有着更好的性能。
        List<String> linkList = new LinkedList<>();
        linkList.add("makjie");
        linkList.add("张三");
        linkList.add("李四");
        linkList.add("王五");
        linkList.add("赵六");
        linkList.add(0, "曾七");
        linkList.set(3,"whl");
        linkList.remove("李四");
        for (String str:linkList) {
            System.out.println(str);
        }
    }

    @Test
    @DisplayName("集合Map测试")
    void treeMapTest(){
        Map<String,Object> map = new TreeMap<>();
    }
}
