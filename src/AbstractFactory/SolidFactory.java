package AbstractFactory;

public class SolidFactory implements AbstractFactory{
    private Brush solidCircle;
    private Brush solidRect;
    private Brush solidTriangle;

    public SolidFactory(){
        createCircle();
        createRect();
        createTriangle();
        System.out.println("成功创建Solid工厂");
    }

    @Override
    public void createCircle() {
        solidCircle=new SolidCircle();
    }

    @Override
    public void createTriangle() {
        solidTriangle=new SolidTriangle();
    }

    @Override
    public void createRect() {
        solidRect=new SolidRect();
    }

    @Override
    public Brush getCircle() {
        return solidCircle;
    }

    @Override
    public Brush getRect() {
        return solidRect;
    }

    @Override
    public Brush getTriangle() {
        return solidTriangle;
    }
}
