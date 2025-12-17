package questions;

public class FramedShape extends Shape{
    private Shape innerShape;

    public FramedShape(Shape shape){
        this.innerShape = shape;
    }
    @Override
    public void draw() {
        innerShape.draw();
        System.out.println("Drawing frame around shape");
    }
}
