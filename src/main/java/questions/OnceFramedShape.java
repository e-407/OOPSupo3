package questions;

public class OnceFramedShape extends Shape{
    private Shape innerShape;

    public <T extends Shape & Frameable> OnceFramedShape(T shape){
        this.innerShape = shape;
    }

    @Override
    public void draw() {
        innerShape.draw();
        System.out.println("Drawing frame around shape");
    }
}