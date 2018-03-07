package weather;

public class MainEntity {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("temp_max")
    public double tempMax;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("temp_min")
    public double tempMin;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("humidity")
    public int humidity;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("pressure")
    public int pressure;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("temp")
    public double temp;
}
