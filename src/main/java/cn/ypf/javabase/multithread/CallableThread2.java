package cn.ypf.javabase.multithread;

import java.util.concurrent.*;

public class CallableThread2 {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        System.out.println("当前线程的名字是:"+Thread.currentThread());
        ExecutorService executor = new ThreadPoolExecutor(3, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        //定义Callable的call方法
        Callable customCallable = new Callable() {
            //支持返回类型和可检查到的异常
            @Override
            public String call() throws Exception {
                System.out.println("当前线程的名字是:"+Thread.currentThread());
                return "succ";
            }
        };
        //使用Future得到call方法中的返回值
        Future future = executor.submit(customCallable);

        System.out.println("多线程中的返回值为"+future.get());


    }

}