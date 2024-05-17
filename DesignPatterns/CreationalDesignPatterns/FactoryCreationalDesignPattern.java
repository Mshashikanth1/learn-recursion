package DesignPatterns.CreationalDesignPatterns;



/*
* Factory Creational Desing patterns:
* it provides loose cupleing  of objects for different types of implementations of an inreface , i
* iot provides a api/ a frame work so we just give the type of ojbect we rea.and it will indentify that
* implementation
*
* Factory Method: This pattern promotes loose coupling by providing an interface for creating objects without specifying the exact implementation class. It allows for centralized object creation and simplifies switching between different implementations.
* */

public class FactoryCreationalDesignPattern {


    interface Shape {
        void draw();
    }

    class Circle implements  Shape{
        @Override
        public void draw(){
            System.out.println("drawing circle.... \n done");
        }
    }

    class Square implements  Shape{

        @Override
        public void draw(){
            System.out.println("drawing square... \n done");
        }
    }


    public void drawShape(String shapeType){
        if(shapeType.equals("CIRCLE")) {
            new Circle();
        }else if(shapeType.equals("SQUARe")){
            new Square();
        }else {
            System.out.println("there is no shape");
        }

    }
}
