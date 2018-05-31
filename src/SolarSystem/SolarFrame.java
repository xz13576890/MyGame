package SolarSystem;

import SolarSystem.util.Constant;
import SolarSystem.util.GameUtil;
import SolarSystem.util.MyFrame;

import java.awt.*;

/**
 * The main window of solar system
 */
public class SolarFrame extends MyFrame {

    protected SolarFrame(String s){
        super(s);
    }

    private Image bg = GameUtil.getImage("SolarSystem/images/bg.png");
    Star sun  = new Star("SolarSystem/images/Sun.png", Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2,
            "太阳");
    Planet mercury = new Planet(sun, "SolarSystem/images/Mercury.png", 50, 36, 0.4446,
            "水星");
    Planet venus = new Planet(sun, "SolarSystem/images/Venus.png", 88, 67, 0.0176,
            "金星");
    Planet earth = new Planet(sun,"SolarSystem/images/Earth.png",150,93,0.0108,
            "地球");
    Planet moon = new Planet(earth,"SolarSystem/images/Moon.png",15,10,0.1332,
            "月球",true);
    Planet mars = new Planet(sun,"SolarSystem/images/Mars.png",210,120,0.0056,
            "火星");
    Planet jupiter = new Planet(sun, "SolarSystem/images/Jupiter.png", 240, 150, 0.0008,
            "木星");
    Planet saturn = new Planet(sun, "SolarSystem/images/Saturn.png", 270, 180, 0.0004,
            "土星");
    Planet uranus = new Planet(sun, "SolarSystem/images/Uranus.png", 300, 210, 0.00008,
            "天王星");
    Planet neptune = new Planet(sun, "SolarSystem/images/Neptune.png", 350, 250, 0.00001,
            "海王星");

    public void paint(Graphics g){
        g.drawImage(bg,0,0,null);
        sun.draw(g);
        mercury.draw(g);
        venus.draw(g);
        earth.draw(g);
        moon.draw(g);
        mars.draw(g);
        jupiter.draw(g);
        saturn.draw(g);
        uranus.draw(g);
        neptune.draw(g);
    }

    public static void main(String[] args) {
        new SolarFrame("太阳系模型").launchFrame();
    }

}
