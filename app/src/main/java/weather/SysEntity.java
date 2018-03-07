package weather;

public class SysEntity {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("sunset")
    public int sunset;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("sunrise")
    public int sunrise;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("country")
    public String country;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("message")
    public double message;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("id")
    public int id;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("type")
    public int type;
}
