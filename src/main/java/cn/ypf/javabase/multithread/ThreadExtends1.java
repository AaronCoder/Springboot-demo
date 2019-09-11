package cn.ypf.javabase.multithread;

public class ThreadExtends1 {
    public static void main(String args[]){
        System.out.println("当前线程的名字是:"+Thread.currentThread());
        CustomThread customThread = new CustomThread();
        customThread.start();
    }
}

class CustomThread extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程的名字是:"+Thread.currentThread());
    }
}
