package SolarSystem;

import SolarSystem.util.Constant;
import SolarSystem.util.GameUtil;
import SolarSystem.util.MyFrame;

import java.awt.*;

/**
 * The main window of solar system
 */
public class SolarFrame extends MyFrame {

    private Image bg = GameUtil.getImage("SolarSystem/images/bg.png");
    Star sun  = new Star("SolarSystem/images/Sun.png", Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);




    public void paint(Graphics g){
        g.drawImage(bg,0,0,null);
        sun.draw(g);




    }


    public static void main(String[] args) {
        new SolarFrame().launchFrame();
    }



}
