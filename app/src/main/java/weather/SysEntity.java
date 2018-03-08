package weather;

public class SysEntity {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("sunset")
    public double sunset;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("sunrise")
    public double sunrise;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("country")
    public String country;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("message")
    public double message;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("id")
    public double id;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("type")
    public double type;
}
