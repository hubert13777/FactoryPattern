package BuilderPattern;

import javax.swing.*;
import java.awt.*;

public class Client {
    public static void main(String[] args) {
        Product p=new Product();
        AbstractBuilder builder=new Builder(p);
        Director d=new Director(builder);
        d.draw();
    }
}
