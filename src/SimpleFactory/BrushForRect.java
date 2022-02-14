package SimpleFactory;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BrushForRect extends Brush {
    public BrushForRect(){
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

                    if (x_start > x_end) {
                        int temp = x_start;
                        x_start = x_end;
                        x_end = temp;
                    }
                    if (y_start > y_end) {
                        int temp = y_start;
                        y_start = y_end;
                        y_end = temp;
                    }
                    graphics.drawRect(x_start, y_start, Math.abs(x_start - x_end), Math.abs(y_start - y_end));
                }else{
                    eraser();
                }
            }
        });
    }
}
