package cn.ypf.controller;

import cn.ypf.javabase.async.AsyncBox;
import org.springframework.beans.factory.annotation.Autowired;

public class AsyncTest {
    @Autowired
    private static AsyncBox asyncBox;

    public static void main(String args[]){
        System.out.println("当前线程名字是:"+Thread.currentThread().getName());
        asyncBox.print();
    }
}
