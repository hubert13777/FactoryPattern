package FactoryMethod;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BrushForPoint extends Brush {
    public BrushForPoint(){
        setBackground(Color.white);
        drawOrEraser=true;

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x_start = e.getX();
                y_start = e.getY();
                if(drawOrEraser==true){
                    graphics.setColor(Color.black);
                    graphics.fillOval(x_start,y_start,5,5);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x_end = e.getX();
                y_end = e.getY();
                if(drawOrEraser==false) {
                    eraser();
                }
            }
        });
    }

}
