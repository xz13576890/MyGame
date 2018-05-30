package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 继承MyFrame的新类，可以简化代码
 * @author XZ
 */
public class GameFrame05 extends MyFrame{  //GUI programming: AWT, swing...

    Image img = GameUtil.getImage("test/images/yellow_star.png");//加载图片

    private double x=100,y=100;//coordinates
    private double degree = 3.14/3;  //弧度[0,2pi]


    @Override //重写的画图方法，具体画什么都在这里
    public void paint(Graphics g) {

        g.drawImage(img,(int)x,(int)y,null);

        x = 100 + 100*Math.cos(degree);//椭圆轨迹
        y = 200 + 100*Math.sin(degree);//椭圆轨迹

        degree += 0.1;


    }


    public static void main(String[] args) {
        GameFrame05 gf = new GameFrame05();
        gf.launchFrame();
    }


}
