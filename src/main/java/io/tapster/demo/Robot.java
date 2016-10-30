package io.tapster.demo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;

public class Robot {
  private String robotURL;
  private double safety;
  private double surface;

  public Robot(String url, double safetyHeight, double surfaceHeight) {
    safety = safetyHeight;
    surface = surfaceHeight;
    robotURL = url;
  }

  public void circle(double x,
                     double y,
                     double z,
                     double radius,
                     double speed,
                     int rotations,
                     String direction) {
      if (direction.equals("cw")) {
        System.out.println("  Demo: Circle - Clockwise");
      } else {
        System.out.println("  Demo: Circle - Counterclockwise");
      }
      try {
        JsonObject obj = new JsonObject();
        obj.addProperty("x", x);
        obj.addProperty("y", y);
        obj.addProperty("z", z);
        obj.addProperty("radius", radius);
        obj.addProperty("speed", speed);
        obj.addProperty("rotations", rotations);
        obj.addProperty("direction", direction);

        sendCommand("circle", obj);

      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public void square() {
      System.out.println("  Demo: Square");
      try {
        go(0, 0, safety);
        go(-20, 20, surface);
        go(20, 20, surface);
        go(20, -20, surface);
        go(-20, -20, surface);
        go(-20, 20, surface);
        go(0, 0, safety);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public void tap() {
      System.out.println("  Demo: Tap");
      try {
        go(0, 0, safety);
        go(0, 0, surface);
        go(0, 0, safety);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public void triangle() {
      System.out.println("  Demo: Triangle");
      try {
        go(0, 20, surface);
        go(20, -20, surface);
        go(-20, -20, surface);
        go(0, 20, surface);
        go(0, 0, safety);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public void swipeUp() {
      System.out.println("  Demo: Swipe Up");
      try {
        go(0, -20, safety);
        go(0, -20, surface);
        go(0, 20, surface);
        go(0, 20, safety);
        go(0, 0, safety);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public void swipeDown() {
      System.out.println("  Demo: Swipe Down");
      try {
        go(0, 20, safety);
        go(0, 20, surface);
        go(0, -20, surface);
        go(0, -20, safety);
        go(0, 0, safety);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public void swipeLeft() {
      System.out.println("  Demo: Swipe Left");
      try {
        go(20, 0, safety);
        go(20, 0, surface);
        go(-20, 0, surface);
        go(-20, 0, safety);
        go(0, 0, safety);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public void swipeRight() {
      System.out.println("  Demo: Swipe Right");
      try {
        go(-20, 0, safety);
        go(-20, 0, surface);
        go(20, 0, surface);
        go(20, 0, safety);
        go(0, 0, safety);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public void go(double x, double y, double z) {
      try {
        JsonObject obj = new JsonObject();
        obj.addProperty("x", x);
        obj.addProperty("y", y);
        obj.addProperty("z", z);

        sendCommand("go", obj);

      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public void sendCommand(String command, JsonObject object) {
    try {
      URL url = new URL(robotURL + command);

      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("POST");
      con.setRequestProperty("Content-Type", "application/json");
      con.setDoOutput(true);

      OutputStream os = con.getOutputStream();
      os.write( object.toString().getBytes("UTF-8") );
      os.flush();
      os.close();

      int responseCode = con.getResponseCode();

      if (responseCode == HttpURLConnection.HTTP_OK) {
        // System.out.println("OK");
      } else {
        System.out.println("Response Code: " + responseCode);
        System.out.println("Request failed.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}