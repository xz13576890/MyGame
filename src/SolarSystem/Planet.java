package SolarSystem;

import SolarSystem.util.GameUtil;

import java.awt.*;

/**
 * 行星的类，除了图片和坐标，还有椭圆运行轨迹：长轴，短轴，速度，角度,以某个恒星为中心
 */
public class Planet extends Star{

    double longAxis;
    double shortAxis;
    double speed;
    double degree;
    Star center;
    boolean satellite;//是卫星就不画轨道

    public Planet(Star center, String imgpath, double longAxis,
                  double shortAxis, double speed) {
        //重载父类构造器
        super(GameUtil.getImage(imgpath));//直接调用父类的一个重载构造器
//        this.img = GameUtil.getImage(imgpath);
//        this.width = img.getWidth(null);
//        this.height = img.getHeight(null);
        this.center = center;
        this.x = center.x + longAxis;
        this.y = center.y + shortAxis;
        this.longAxis = longAxis;
        this.shortAxis = shortAxis;
        this.speed = speed;
    }

    public Planet(Star center, String imgpath, double longAxis, double shortAxis,
                  double speed,String name) {
        //重载构造器
        this(center, imgpath, longAxis, shortAxis, speed);//直接用this调用上面的构造器
        this.name = name;
    }

    public Planet(Star center, String imgpath, double longAxis, double shortAxis,
                  double speed,String name,boolean satellite) {
        //重载构造器
        this(center, imgpath, longAxis, shortAxis, speed,name);//直接用this调用上面的构造器
        this.satellite = satellite;
    }


    @Override
    public void draw(Graphics g){

        super.draw(g);
        if (!satellite){ //不是卫星才画轨道
            drawTrace(g);
        }
        move();
    }

    public void drawTrace(Graphics g){
        //画行星的轨迹
       double ovalX,ovalY,ovalWidth,ovalHeight;

        ovalWidth = longAxis*2;
        ovalHeight = shortAxis*2;
        ovalX = center.x + center.width/2 - longAxis ;
        ovalY = center.y + center.height/2 - shortAxis;

        Color c = g.getColor();
        g.setColor(Color.BLUE);
        g.drawOval((int)ovalX,(int)ovalY,(int)ovalWidth,(int)ovalHeight);
        g.setColor(c);

    }

    public void move(){
        //沿star圆心以椭圆轨迹飞行
        x = (center.x + center.width/2) + longAxis * Math.cos(degree) - this.width/2;
        y = (center.y + center.height/2) + shortAxis * Math.sin(degree) - this.height/2;
        degree += speed;
    }

}
