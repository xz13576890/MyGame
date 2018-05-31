package SolarSystem;

import SolarSystem.util.GameUtil;
import java.awt.*;

/**
 * 星星类模板
 */
public class Star {
    Image img;//图片
    double x,y;//坐标
    double width,height;//图片的长度和宽度
    String name;

    public void draw(Graphics g){ //显示自己
        int layOutX = (int)(x - img.getWidth(null)/2);
        int layOutY = (int)(y - img.getHeight(null)/2);
        g.drawImage(img,layOutX,layOutY,null);
        if (name != null){
            Color c = g.getColor();
            g.setColor(Color.white);
            g.drawString(this.name, (int) x, (int) y);
            g.setColor(c);
        }
    }

    public Star() { //无参构造器
    }

    public Star(Image img){ //单独参数的重载构造器，方便下面几个重载内嵌调用，简化代码
        this.img = img;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        System.out.println("width: "+ this.width);
        System.out.println("height: "+ this.height);
    }

    public Star(Image img, double x, double y) {
        this(img); //通过this调用另一个构造方法,简化代码的写法
        this.x = x;
        this.y = y;
    }

    public Star(String imgpath, double x, double y,String name) { //通过this调用另一个构造方法
        this(GameUtil.getImage(imgpath),x,y);
        this.name = name;

    }


}
