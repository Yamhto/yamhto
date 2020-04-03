package com.yamhto.javaStudy.juc;

/**
 * @author yamhto
 * @className: TestVolatile.java
 * @package com.yamhto.javaStudy.juc
 * @description:
 * @date 2020/4/2 15:33
 */
public class TestVolatile {
    public static void main(String[] args){ //这个线程是用来读取flag的值的
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
        while (true){
            //synchronized (threadDemo) {
                if (threadDemo.isFlag()) {
                    System.out.println("主线程读取到的flag = " + threadDemo.isFlag());
                    break;
                }
            //}
        }
    }
}

class ThreadDemo implements Runnable{ //这个线程是用来修改flag的值的
    public volatile   boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("ThreadDemo线程修改后的flag = " + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
