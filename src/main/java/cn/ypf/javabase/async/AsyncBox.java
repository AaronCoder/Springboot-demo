package cn.ypf.javabase.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncBox {
    @Async
    public void print(){
        System.out.println("外面是阴雨天，看来周末又是玩不了了");
        System.out.println("当前的线程名是:"+Thread.currentThread().getName());
    }
}
