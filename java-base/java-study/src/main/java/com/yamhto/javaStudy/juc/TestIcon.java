package com.yamhto.javaStudy.juc;

/**
 * @author yamhto
 * @className: TestIcon.java
 * @package com.yamhto.javaStudy.juc
 * @description: 测试原子性
 * @date 2020/4/2 16:22
 */
public class TestIcon {
    public static void main(String[] args){
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int x = 0;x < 10; x++){
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable{
    private int i = 0;
    public int getI(){
        return i++;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getI());
    }
}
