package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Game 窗口类
 * @author XZ
 */
public class GameFrame extends Frame{  //GUI programming: AWT, swing...
    /**
     * 加载窗口
     */
    private void launchFrame(){
        setSize(500,500);
        setLocation(300,300);
        setVisible(true);

        addWindowListener(new WindowAdapter() { //关闭窗口
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawLine(100,100,200,200); //画线
        g.drawRect(100,100,200,200);//画矩形
        g.drawOval(100,100,200,200);//画圆

        Font f = new Font("宋体",Font.BOLD,20);//创建自定义字体

        g.setFont(f);//设置字体
        g.drawString("嘟嘟噜",200,200);//写字符串

        g.fillRect(100,100,20,20);//画填充矩形

        Color c = g.getColor();//在改颜色前记录当前颜色，防止以后记不得初始的颜色
        g.setColor(Color.red);//更改画笔颜色
        g.fillOval(300,300,20,20);//画填充圆（被当前画笔改为红色了）

        g.setColor(c);//画完图后把画笔颜色改为初始值

    }




    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        gf.launchFrame();
    }


}
