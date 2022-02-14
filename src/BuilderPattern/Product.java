package BuilderPattern;

import javax.swing.*;
import java.awt.*;

public class Product{
    protected Graphics graphics;
    protected JFrame jf = new JFrame("建造者模式绘图");
    protected JPanel drawArea=new JPanel();

    public Product(){
        jf.setBounds(300, 200, 600, 400);
        jf.setLayout(new BorderLayout());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawArea.setBackground(Color.white);

        jf.add(drawArea);
        jf.setVisible(true);
    }

    public void setGraphics(){
        graphics=drawArea.getGraphics();
        if(graphics==null) System.out.println("graphics is null!");
    }
}
