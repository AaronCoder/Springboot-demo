package cn.ypf.javabase.multithread;

public class ThreadExtends3 {
    public static void main(String args[]){
        System.out.println("当前线程的名字是:"+Thread.currentThread());
        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程的名字是:"+Thread.currentThread());}
        ).start();
    }
}
