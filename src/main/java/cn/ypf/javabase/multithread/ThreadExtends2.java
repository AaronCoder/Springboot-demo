package cn.ypf.javabase.multithread;

public class ThreadExtends2 {
    public static void main(String args[]){
        System.out.println("当前线程名称是:"+Thread.currentThread());
        //使用匿名内部类来创建线程
        new Thread(){
            @Override
            public void run(){
                System.out.println("当前线程名称是:"+Thread.currentThread());
            }
        }.start();
    }
}
