package BuilderPattern;

import javax.swing.*;

abstract class AbstractBuilder {
    protected Product brush;

    public abstract void drawTriangle();
    public abstract void drawRect();
    public abstract void drawCircle();

    public Product getResult(){
        return brush;
    }
}
