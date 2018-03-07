package weather;

public class WeatherEntity {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("icon")
    public String icon;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("description")
    public String description;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("main")
    public String main;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("id")
    public int id;
}
