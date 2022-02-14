package AbstractFactory;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HollowCircle extends Brush {
    public HollowCircle(){
        setBackground(Color.white);
        drawOrEraser=true;
        message="此时Brush是圆形";

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x_start = e.getX();
                y_start = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x_end = e.getX();
                y_end = e.getY();
                if(drawOrEraser==true){
                    graphics.setColor(Color.black);
                    int width=(int)Math.sqrt(Math.pow((x_start-x_end),2)+Math.pow((y_start-y_end),2));
                    graphics.drawOval(x_start,y_start,width,width);
                }else{
                    eraser();
                }
            }
        });
    }

}
