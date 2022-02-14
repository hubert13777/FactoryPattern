package AbstractFactory;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HollowTriangle extends Brush {
    private int x_first,y_first; //用来存储三角形起点
    private int edgeNum;  //0表示三角形已完成或未开始，1、2表示正在绘制
    public HollowTriangle(){
        setBackground(Color.white);
        drawOrEraser=true;
        message="此时Brush是三角形";

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(drawOrEraser==true) {
                    if (edgeNum == 0) {
                        x_first = getX();
                        y_first = getY();
                        edgeNum = 1;
                    } else if (edgeNum == 1) {
                        x_start = getX();
                        y_start = getY();
                        graphics.setColor(Color.black);
                        graphics.drawLine(x_first, y_first, x_start, y_start);
                        edgeNum = 2;
                    } else {
                        x_end = getX();
                        y_end = getY();
                        graphics.setColor(Color.black);
                        graphics.drawLine(x_start, y_start, x_end, y_end);
                        graphics.drawLine(x_end, y_end, x_first, y_first);
                        edgeNum = 0;
                    }
                }else{
                    edgeNum=0;
                    x_start=getX();
                    y_start=getY();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(drawOrEraser==false) {
                    x_end = e.getX();
                    y_end = e.getY();
                    eraser();
                }
            }
        });
    }
}
