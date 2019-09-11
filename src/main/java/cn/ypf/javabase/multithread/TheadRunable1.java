package cn.ypf.javabase.multithread;

public class TheadRunable1 {
    public static void main(String args[]){
        System.out.println("当前的线程名称是:"+Thread.currentThread());
        RunnableThread runnableThread = new RunnableThread();
        new Thread(runnableThread).start();
    }
}
class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("当前的线程名称是:"+Thread.currentThread());
    }
}
