package weather;

public class CoordEntity {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("lat")
    public double lat;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("lon")
    public double lon;
}
