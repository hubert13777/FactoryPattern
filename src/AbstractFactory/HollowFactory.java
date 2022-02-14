package AbstractFactory;

public class HollowFactory implements AbstractFactory{
    private Brush hollowCircle;
    private Brush hollowRect;
    private Brush hollowTriangle;

    public HollowFactory(){
        createCircle();
        createRect();
        createTriangle();
        System.out.println("成功创建Hollow工厂");
    }

    @Override
    public void createCircle() {
        hollowCircle=new HollowCircle();
    }

    @Override
    public void createTriangle() {
        hollowTriangle=new HollowTriangle();
    }

    @Override
    public void createRect() {
        hollowRect=new HollowRect();
    }

    @Override
    public Brush getCircle() {
        return hollowCircle;
    }

    @Override
    public Brush getRect() {
        return hollowRect;
    }

    @Override
    public Brush getTriangle() {
        return hollowTriangle;
    }
}
