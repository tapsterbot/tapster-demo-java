package io.tapster.demo;

import io.tapster.demo.Robot;

/*
 * Tapster Demo!
 */
public class Demo {
  public static void main( String[] args ) {
    try {
      System.out.println( "Tapster Robot - Examples" );
      Robot robot = new Robot();

      if (args.length > 0) {
        String example = args[0];
        if (example.equals("circle")) {
          String direction = "cw";
          double speed = 1.5;
          if (args.length > 1) {
            String directionArg = args[1];
            if (directionArg.equals("ccw")) {
              direction = "ccw";
            }
            if (args.length > 2) {
              String speedArg = args[2];
              if (speedArg.equals("slow")) {
                speed = 3.5;
              }
            }
          }
          robot.circle(0.0, 0.0, -150.0, 20.0, speed, 5, direction);
        } else if (example.equals("square")) {
          robot.square();
        } else if (example.equals("tap")) {
          robot.tap();
        } else if (example.equals("triangle")) {
          robot.triangle();
        } else if (example.equals("swipeUp")) {
          robot.swipeUp();
        }  else if (example.equals("swipeDown")) {
          robot.swipeDown();
        } else if (example.equals("swipeLeft")) {
          robot.swipeLeft();
        } else if (example.equals("swipeRight")) {
          robot.swipeRight();
        }

      } else {
        robot.tap();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


