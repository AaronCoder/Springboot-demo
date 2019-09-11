package cn.ypf.javabase.multithread;

import java.util.concurrent.*;

public class CustomMultiThread {
    public static void main(String args[]){
        System.out.println("当前线程名字是:"+Thread.currentThread());
        ExecutorService executor =   new ThreadPoolExecutor(3, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        executor.submit(new Thread(()->System.out.println("当前线程名字是:"+Thread.currentThread())));


        /* executor.execute(()->{
                    for(int i=1;i<=5;i++){
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("当前线程的名字是:"+Thread.currentThread());
                        System.out.println("当前的活跃线程数是:"+Thread.activeCount());
                    }
                }
        );*/



    }

}
