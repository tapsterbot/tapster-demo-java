# Java Examples for Tapster 2

[![Controller Demo Video](https://img.youtube.com/vi/JQ-_l8UrPgM/0.jpg)](https://www.youtube.com/watch?v=JQ-_l8UrPgM)

## 1) Compile with dependencies included
    mvn clean compile assembly:single

## 2) Run
(With no command line parameters, it will run the tap once demo...)

    java -jar target/tapster-demo-1.0.jar

# Examples:

## Tap once
    java -jar target/tapster-demo-1.0.jar tap

## Draw an arc
    java -jar target/tapster-demo-1.0.jar arc

## Draw a square
    java -jar target/tapster-demo-1.0.jar square

## Draw a triangle
    java -jar target/tapster-demo-1.0.jar triangle

## Draw 5 circles clockwise
    java -jar target/tapster-demo-1.0.jar circle
    java -jar target/tapster-demo-1.0.jar circle false

## Draw 5 circles clockwise, slowly
    java -jar target/tapster-demo-1.0.jar circle false slow

## Draw 5 circles anticlockwise
    java -jar target/tapster-demo-1.0.jar circle true

## Draw 5 circles anticlockwise, slowly
    java -jar target/tapster-demo-1.0.jar circle true slow

## Swipe Up
    java -jar target/tapster-demo-1.0.jar swipeUp

## Swipe Down
    java -jar target/tapster-demo-1.0.jar swipeDown

## Swipe Left
    java -jar target/tapster-demo-1.0.jar swipeLeft

## Swipe Right
    java -jar target/tapster-demo-1.0.jar swipeRight

