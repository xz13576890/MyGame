package SolarSystem.util;

import java.awt.*;

/**
 * 游戏开发中常用的工具类(eg.load images)
 */
public class GameUtil {

    private GameUtil(){} //工具类通常会将构造方法私有

    public static Image getImage(String path){
        /*
        URL u = GameUtil.class.getClassLoader().getResource(path);
        BufferedImage img = null;
        try {
            img = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
        */
        return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));

    }

}
