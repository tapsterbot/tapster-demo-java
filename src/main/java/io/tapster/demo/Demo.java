package io.tapster.demo;

import java.io.IOException;
import java.io.InputStream;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;

import io.tapster.demo.Robot;

/*
 * Tapster Demo!
 */
public class Demo {
  public static void main( String[] args ) {
    try {
      Demo demo = new Demo();
      String config = demo.resourceToString("/config.json");
      JsonObject object = new Gson().fromJson(config, JsonObject.class);

      String robotURL = object.get("robotURL").getAsString();
      double safetyHeight = object.get("safetyHeight").getAsDouble();
      double surfaceHeight = object.get("surfaceHeight").getAsDouble();

      Robot robot = new Robot(robotURL, safetyHeight, surfaceHeight);

      System.out.println( "Tapster Robot - Examples" );

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
          robot.circle(0.0, 0.0, surfaceHeight, 20.0, speed, 5, direction);
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

  private String resourceToString(String filePath) {
      try {
        InputStream inputStream = this.getClass().getResourceAsStream(filePath);
        return IOUtils.toString(inputStream, "UTF-8");
      } catch (IOException e) {
        e.printStackTrace();
        System.exit(1);
        return "";
      }
  }
}