package FactoryMethod;

public class BrushFactory implements AbstractFactory{
    @Override
    public Brush getProduct(String className) {
        Brush draw;
        try {
            Class c=Class.forName(className);
            draw=(Brush)c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("类获取失败！");
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

        return draw;
    }
}
