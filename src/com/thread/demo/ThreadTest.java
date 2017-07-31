package com.thread.demo;

public class ThreadTest {
	/**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
        synchronized (r) {
            try {
                System.out.println("main thread �ȴ�t�߳�ִ����");
                r.wait();
                System.out.println("��notity���ѣ����Լ���ִ��");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("main thread ����ȴ���������������");
            }
            System.out.println("�߳�tִ����ӽ��" + r.getTotal());
        }
    }
}

class MyRunnable implements Runnable {
    private int total;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        synchronized (this) {
            System.out.println("Thread name is:" + Thread.currentThread().getName());
            
            for (int i = 0; i < 10; i++) {
                total += i;
            }
            notify();
            System.out.println("ִ��notif��ͬ�����������Ȼ���Լ���ִ��ֱ�����");
        }
        System.out.println("ִ��notif����ͬ���������Ĵ���ִ��ʱ��ȡ�����̵߳���");
    }

    public int getTotal() {
        return total;
    }
}