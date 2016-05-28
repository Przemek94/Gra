package com.example.ziom.jtr;

/**
 * Created by Przemek on 2016-05-27.
 */
public class Punkty {

    private String username, points;

    public Punkty(String username, String points){
        this.setUsername(username);
        this.setPoints(points);
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
