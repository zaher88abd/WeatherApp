package weather;

public class WindEntity {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("gust")
    public double gust;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("deg")
    public double deg;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("speed")
    public double speed;
}
