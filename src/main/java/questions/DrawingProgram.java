package questions;

import java.util.List;

public class DrawingProgram {
    List<Shape> shapeList;

    public void drawShapes(){
        for (Shape shape : shapeList){
            shape.draw();
        }
    }
}
