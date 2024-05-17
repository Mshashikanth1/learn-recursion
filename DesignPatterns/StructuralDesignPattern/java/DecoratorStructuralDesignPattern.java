package DesignPatterns.StructuralDesignPattern.java;


/*
*
* Decorator: This pattern dynamically adds or modifies the behavior of an object at runtime without subclassing.
     It's useful for adding optional functionalities without modifying the core object.
*
*
*
* */
public class DecoratorStructuralDesignPattern {

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

    static class ColoredShapeDecorator implements Shape {
        private Shape decoratedShape;
        private String color;

        public ColoredShapeDecorator(Shape shape, String color) {
            this.decoratedShape = shape;
            this.color = color;
        }

        @Override
        public void draw() {
            decoratedShape.draw();
            System.out.println(" Colored with " + color);
        }
    }
}


