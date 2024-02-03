package org.example.designpattern.singleton;
//@Author : Sk Alamin
// Implementor interface
interface DrawingAPI {
    void drawCircle(double x, double y, double radius);
    void drawSquare(double x, double y, double side);
}

// Concrete Implementor 1
class VectorDrawingAPI implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing Circle in Vector at (" + x + "," + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(double x, double y, double side) {
        System.out.println("Drawing Square in Vector at (" + x + "," + y + ") with side " + side);
    }
}

// Concrete Implementor 2
class RasterDrawingAPI implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing Circle in Raster at (" + x + "," + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(double x, double y, double side) {
        System.out.println("Drawing Square in Raster at (" + x + "," + y + ") with side " + side);
    }
}

// Abstraction
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    abstract void draw();
}

// Refined Abstraction
class Circle extends Shape {
    private double x, y, radius;

    public Circle(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}

// Refined Abstraction
class Square extends Shape {
    private double x, y, side;

    public Square(double x, double y, double side, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.side = side;
    }

    @Override
    void draw() {
        drawingAPI.drawSquare(x, y, side);
    }
}

// Client Code
public class BridgePattern {
    public static void main(String[] args) {
        DrawingAPI vectorDrawingAPI = new VectorDrawingAPI();
        DrawingAPI rasterDrawingAPI = new RasterDrawingAPI();

        Shape circle = new Circle(1, 2, 3, vectorDrawingAPI);
        Shape square = new Square(5, 7, 10, rasterDrawingAPI);

        circle.draw();
        square.draw();
    }
}
