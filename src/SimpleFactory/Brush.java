package SimpleFactory;

import javax.swing.JPanel;
import java.awt.*;

public class Brush extends JPanel {
    protected int x_start;
    protected int y_start;
    protected int x_end;
    protected int y_end;
    protected Graphics graphics;
    protected boolean drawOrEraser; //false表示橡皮擦，true表示画笔

    public void setGraphics(){
        graphics=getGraphics();
        if(graphics==null) System.out.println("graphics is null!");
    }
    public void setDrawOrEraser(){
        drawOrEraser=!drawOrEraser;
    }
    protected void eraser(){
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
        graphics.setColor(Color.white);
        graphics.fillRect(x_start, y_start, Math.abs(x_start - x_end), Math.abs(y_start - y_end));
    }
}
