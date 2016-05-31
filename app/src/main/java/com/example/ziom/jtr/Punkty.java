package com.example.ziom.jtr;

/**
 * Created by Przemek on 2016-05-27.
 */
public class Punkty {

    private String username, points, id;


    public Punkty(String id, String username, String points){
        this.setUsername(username);
        this.setPoints(points);
        this.setId(id);

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
