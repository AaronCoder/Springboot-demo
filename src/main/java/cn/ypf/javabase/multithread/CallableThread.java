package cn.ypf.javabase.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableThread {
    public static void main(String args[]){
        System.out.println("当前的线程名字是:"+Thread.currentThread());

        CustomCallable customCallable = new CustomCallable();
        FutureTask futureTask = new FutureTask(customCallable);
        Thread thread = new Thread(futureTask);
        thread.start();

    }
}
class CustomCallable implements Callable{
    //支持协变返回类型
    @Override
    public String call() throws Exception {
        System.out.println("当前的线程名字是:"+Thread.currentThread());
        return "succ";
    }
}