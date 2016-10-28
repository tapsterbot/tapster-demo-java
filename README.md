# Java Examples for Tapster 2

# 1) Compile with dependencies included
    mvn clean compile assembly:single

# 2) Run
(With no command line parameters, it will run the tap once demo...)

    java -jar target/tapster-demo-1.0.jar

# Examples:

## Tap once
    java -jar target/tapster-demo-1.0.jar tap

## Draw a square
    java -jar target/tapster-demo-1.0.jar square

## Draw a triangle
    java -jar target/tapster-demo-1.0.jar triangle

## Draw 5 circles clockwise
    java -jar target/tapster-demo-1.0.jar circle
    java -jar target/tapster-demo-1.0.jar circle cw

## Draw 5 circles clockwise, slowly
    java -jar target/tapster-demo-1.0.jar circle cw slow

## Draw 5 circles counterclockwise
    java -jar target/tapster-demo-1.0.jar circle ccw

## Draw 5 circles counterclockwise, slowly
    java -jar target/tapster-demo-1.0.jar circle ccw slow

## Swipe Up
    java -jar target/tapster-demo-1.0.jar swipeUp

## Swipe Down
    java -jar target/tapster-demo-1.0.jar swipeDown

## Swipe Left
    java -jar target/tapster-demo-1.0.jar swipeLeft

## Swipe Right
    java -jar target/tapster-demo-1.0.jar swipeRight

