package SolarSystem;

import test.GameUtil;

import java.awt.*;

/**
 * 星星类模板
 */
public class Star {
    private Image img;//图片
    private double x,y;//坐标

    public void draw(Graphics g){ //显示自己
        g.drawImage(img,(int)x,(int)y,null);
    }

    public Star(String imgpath, double x, double y) { //重载构造器
        this.img = GameUtil.getImage(imgpath);
        this.x = x;
        this.y = y;
    }
}
