package AbstractFactory;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SolidTriangle extends Brush {
    private int[] x = new int[3];
    private int[] y = new int[3];
    private int edgeNum;  //0表示三角形已完成或未开始，1、2表示正在绘制

    public SolidTriangle() {
        setBackground(Color.white);
        drawOrEraser = true;
        message="此时Brush是三角形";

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x_start = e.getX();
                y_start = e.getY();
                if (drawOrEraser == true) {
                    if (edgeNum == 0) {
                        System.out.println("获取第一个点");
                        x[0] = x_start;
                        y[0] = y_start;
                        System.out.println(x[0]);
                        System.out.println(y[0]);
                        edgeNum = 1;
                        graphics.setColor(Color.black);
                    } else if (edgeNum == 1) {
                        System.out.println("获取第二个点");
                        x[1] = x_start;
                        y[1] = y_start;
                        System.out.println(x[1]);
                        System.out.println(y[1]);
                        graphics.setColor(Color.black);
                        graphics.drawLine(x[0], y[0], x[1], y[1]);
                        edgeNum = 2;
                    } else {
                        System.out.println("获取第三个点");
                        x[2] = x_start;
                        y[2] = y_start;
                        System.out.println(x[2]);
                        System.out.println(y[2]);
                        graphics.setColor(Color.black);
                        graphics.fillPolygon(x,y,3);
                        edgeNum = 0;
                    }
                } else {
                    edgeNum = 0;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (drawOrEraser == false) {
                    x_end = e.getX();
                    y_end = e.getY();
                    eraser();
                }
            }
        });
    }
}
