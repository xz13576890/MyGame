package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试窗口物体沿椭圆轨迹飞行
 * @author XZ
 */
public class GameFrame04 extends Frame{  //GUI programming: AWT, swing...

    Image img = GameUtil.getImage("test/images/yellow_star.png");//加载图片

    /**
     * 加载窗口
     */
    private void launchFrame(){
        setSize(500,500);
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


    private double x=100,y=100;
    private double degree = 3.14/3;  //弧度[0,2pi]


    @Override //重写的画图方法，具体画什么都在这里
    public void paint(Graphics g) {

        g.drawImage(img,(int)x,(int)y,null);

        x = 100 + 100*Math.cos(degree);//椭圆轨迹
        y = 200 + 100*Math.sin(degree);//椭圆轨迹

        degree += 0.1;


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




    public static void main(String[] args) {
        GameFrame04 gf = new GameFrame04();
        gf.launchFrame();
    }


}
