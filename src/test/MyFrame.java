package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 根据共同窗口需求自定义封装的新类MyFrame，可以便于其它类继承,简化代码
 */
class MyFrame extends Frame{

    /**
     * 加载窗口
     */
    protected void launchFrame(){
        setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        setLocation(300,300);
        setVisible(true);

        new PaintThread().start();//启动重画线程

        addWindowListener(new WindowAdapter() { //关闭窗口
            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(0);
            }
        });//关闭窗口功能
    }

    /**
     * 定义一个重画窗口的内部线程类
     */
    class PaintThread extends Thread{

        public void run(){
            while (true){
                repaint();
                try {
                    Thread.sleep(40);   //1s = 1000ms,画一次线程休息40毫秒，这里相当于一秒画25次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }



}
