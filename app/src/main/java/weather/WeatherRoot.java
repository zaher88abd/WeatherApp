package weather;

import java.util.List;

/**
 * Created by zaher on 2018-03-07.
 */

public class WeatherRoot {

    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("cod")
    public int cod;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("name")
    public String name;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("id")
    public int id;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("sys")
    public SysEntity sys;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("dt")
    public int dt;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("clouds")
    public CloudsEntity clouds;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("wind")
    public WindEntity wind;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("visibility")
    public int visibility;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("main")
    public MainEntity main;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("base")
    public String base;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("weather")
    public List<WeatherEntity> weather;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("coord")
    public CoordEntity coord;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("message")
    public CoordEntity message;
}
