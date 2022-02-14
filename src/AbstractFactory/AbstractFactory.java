package AbstractFactory;

public interface AbstractFactory {
    void createCircle();
    void createTriangle();
    void createRect();

    Brush getCircle();
    Brush getRect();
    Brush getTriangle();
}
