package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试窗口物体沿任意角度飞行,最后实现一个小台球游戏
 * @author XZ
 */
public class GameFrame03 extends Frame{  //GUI programming: AWT, swing...

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
    private double speed = 10;


    @Override //重写的画图方法，具体画什么都在这里
    public void paint(Graphics g) {

        g.drawImage(img,(int)x,(int)y,null);

        if (speed > 0){ // 移动中慢慢减速
            speed -= 0.05;
        }else {
            speed = 0;
        }

        x += speed*Math.cos(degree);//直角三角函数
        y += speed*Math.sin(degree);

        if (y > 500-40){ //触及窗口下方边界时，小球沿X轴入射角度对称反弹
            degree = -degree;
        }
        if (y < 20){
            degree = -degree;
        }

        if (x < 0){ //触及窗口左方边界时，小球沿Y轴Pi－入射弧度对称反弹
            degree = Math.PI - degree;
        }
        if (x > 500 - 40){
            degree = Math.PI - degree;
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
                    Thread.sleep(40);   //1s = 1000ms,画一次线程休息40毫秒，这里相当于一秒画25次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }




    public static void main(String[] args) {
        GameFrame03 gf = new GameFrame03();
        gf.launchFrame();
    }


}
