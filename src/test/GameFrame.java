package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏基本知识测试类（窗口类）
 * @author XZ
 */
public class GameFrame extends Frame{  //GUI programming: AWT, swing...

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



    @Override //重写的画图方法，具体画什么都在这里
    public void paint(Graphics g) {
        g.drawLine(100,100,200,200); //画线
        g.drawRect(100,100,200,200);//画矩形
        g.drawOval(100,100,200,200);//画圆

        Font f = new Font("宋体",Font.BOLD,20);//创建自定义字体

        g.setFont(f);//设置字体
        g.drawString("蓝蓝路",200,200);//写字符串

        g.fillRect(100,100,20,20);//画填充矩形

        Color c = g.getColor();//在改颜色前记录当前颜色，防止以后记不得初始的颜色
        g.setColor(Color.red);//更改画笔颜色
        g.fillOval(300,300,20,20);//画填充圆（被当前画笔改为红色了）

        g.setColor(c);//画完图后把画笔颜色改为初始值

        g.drawImage(img,(int)x,(int)y,null);//显示图片,坐标设为变量，线程重复调用，就形成了动画

        x += 3;//每次线程调用坐标+3
        y += 3;

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
        GameFrame gf = new GameFrame();
        gf.launchFrame();
    }


}
