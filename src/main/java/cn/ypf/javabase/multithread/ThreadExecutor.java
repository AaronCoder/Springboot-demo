package cn.ypf.javabase.multithread;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ThreadExecutor {
    public static void main(String args[]){
        /*BeeperControl beeperControl = new BeeperControl();
        beeperControl.beepForAnHour();*/
        customThreadPoolTest();
    }

    public static void customThreadPoolTest(){
        System.out.println("当前的活跃线程数为:"+Thread.activeCount()+" 当前线程名称是:"+Thread.currentThread());

        ExecutorService executors = new ThreadPoolExecutor(1, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        for(int i = 0;i<4;i++){
            executors.execute(()->{
                System.out.println("当前的活跃线程数为:"+Thread.activeCount()+" 当前线程名称是:"+Thread.currentThread());
            });
            executors.execute(()->{
                System.out.println("当前的活跃线程数为:"+Thread.activeCount()+" 当前线程名称是:"+Thread.currentThread());
            });
        }

    }


    private static void singleThreadPoolTest(){
        System.out.println("当前的活跃线程数为:"+Thread.activeCount());
        //创建单一线程的线程池
        ExecutorService executors = Executors.newSingleThreadExecutor();
        for(int i = 0;i<4;i++){
            executors.execute(()->{
                System.out.println("当前的活跃线程数为:"+Thread.activeCount());
            });
        }
    }

    private static void catchThreadPoolTest(){
        System.out.println("当前的活跃线程数为:"+Thread.activeCount());
        //带有缓存机制的线程池，该线程可设置时效时间，超过时间线程失效(需要重新创建 )
        ExecutorService executors = Executors.newCachedThreadPool();
        for(int i = 0;i<4;i++){
            executors.execute(()->{
                System.out.println("当前的活跃线程数为:"+Thread.activeCount());
            });
        }
    }

    private static void fixThreadPoolTest(){
        System.out.println("当前的活跃线程数为:"+Thread.activeCount());
        //可重用的线程池,即可使用的线程是可以指定最大数量，创建线程后不会释放系统资源
        ExecutorService executors = Executors.newFixedThreadPool(2);
        for(int i = 0;i<4;i++){
            executors.execute(()->{
                System.out.println("当前的活跃线程数为:"+Thread.activeCount());
            });
        }
    }

}

class BeeperControl {
    //创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            @Override
            public void run() { System.out.println("beep"); }
        };
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 3, 2, SECONDS);

        scheduler.schedule(
                new Runnable() {
            @Override
            public void run() { beeperHandle.cancel(true); }
        }, 60 * 60, SECONDS);
    }
}
