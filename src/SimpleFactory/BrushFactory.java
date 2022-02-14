package SimpleFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class BrushFactory {
    public static Brush getProduct(String className){
        Brush draw;
        try {
            Class c=Class.forName(className);
            draw=(Brush)c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("类获取失败！");
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

        return draw;
    }
}
