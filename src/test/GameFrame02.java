package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试窗口物体沿水平和纵向轨迹移动
 * @author XZ
 */
public class GameFrame02 extends Frame{  //GUI programming: AWT, swing...

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
    private boolean left;//方向判断：是否向左移
    private boolean up;// 方向判断：是否向上移



    @Override //重写的画图方法，具体画什么都在这里
    public void paint(Graphics g) {

        g.drawImage(img,(int)x,(int)y,null);
        //触及上下左右窗口边界就反方向,注意坐标也是以星星的左上角为原点
        if (left){
            x -= 3;
        }else {
            x += 3;
        }
        if (x > 500 - 40){ //触及右边窗口边框时
            left = true;
        }
        if (x < 0){
            left = false;
        }

        if (up){
            y -= 10;
        }else {
            y += 10;
        }
        if (y > 500 - 40){
            up = true;
        }
        if (y < 30){
            up = false;
        }


    }

    /**
     * 定义一个重画窗口的内部线程类
     */
    class PaintThread extends Thread{

        public void run(){
            while (true){
                repaint();
                try {
                    Thread.sleep(30);   //1s = 1000ms,画一次线程休息40毫秒，这里相当于一秒画25次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }




    public static void main(String[] args) {
        GameFrame02 gf = new GameFrame02();
        gf.launchFrame();
    }


}
