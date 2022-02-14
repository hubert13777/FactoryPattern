package FactoryMethod;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BrushForLine extends Brush {
    public BrushForLine(){
        setBackground(Color.white);
        drawOrEraser=true;

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
                if(drawOrEraser==true) {
                    graphics.setColor(Color.black);
                    graphics.drawLine(x_start, y_start, x_end, y_end);
                }else{
                    eraser();
                }
            }
        });
    }

}
