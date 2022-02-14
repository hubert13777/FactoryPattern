package BuilderPattern;

public class Director {
    private AbstractBuilder builder;

    public Director(AbstractBuilder builder){
        this.builder=builder;
    }

    public Product draw(){
        builder.brush.setGraphics();
        builder.drawTriangle();
        builder.drawRect();
        builder.drawCircle();
        return builder.getResult();
    }
}
