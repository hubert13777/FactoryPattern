package BuilderPattern;

import java.awt.*;

public class Builder extends AbstractBuilder{
    public Builder(Product brush){
        this.brush=brush;
    }

    @Override
    public void drawTriangle() {
        System.out.println("画了三角形");
        int[] x={350,300,400};
        int[] y={55,140,140};
        brush.graphics.setColor(Color.pink);
        brush.graphics.drawPolygon(x,y,3);
        brush.graphics.fillPolygon(x,y,3);
    }

    @Override
    public void drawRect() {
        System.out.println("画了矩形");
        brush.graphics.setColor(Color.pink);
        brush.graphics.fillRect(200,140,200,60);
    }

    @Override
    public void drawCircle() {
        System.out.println("画了圆形");
        brush.graphics.setColor(Color.pink);
        brush.graphics.fillOval(225,200,50,50);
        brush.graphics.fillOval(340,200,50,50);
    }
}
