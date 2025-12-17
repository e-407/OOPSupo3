package questions;

import java.util.List;

public class CompositeShape extends Shape{
    private List<Shape> innerShapes;

    public CompositeShape(List<Shape> shapes){
        this.innerShapes = shapes;
    }

    public void draw() {
        System.out.println("Drawing a Composite Shape");
        for (Shape shape : innerShapes){
            shape.draw();
        }
    }
}
