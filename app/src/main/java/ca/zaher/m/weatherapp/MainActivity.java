package ca.zaher.m.weatherapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import weather.WeatherRoot;

public class MainActivity extends AppCompatActivity {
    EditText etCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCity = findViewById(R.id.etCityName);
        etCity.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    getWeather(etCity.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    private void getWeather(String cityName) {
        if (cityName.isEmpty()){
            Toast.makeText(this, "Enter the city name", Toast.LENGTH_SHORT).show();
            return;
        }
        InputMethodManager inputManager = (InputMethodManager) MainActivity.this.
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(
                this.getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please, waite...");
        progressDialog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(WeatherInterface.class).getWeather(cityName, getString(R.string.app_id), "metric")
                .enqueue(new Callback<WeatherRoot>() {
                    @Override
                    public void onResponse(Call<WeatherRoot> call, Response<WeatherRoot> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                Log.d("TestWeatherApp", "Good");
                                updateUI(response.body());
                            }
                        } else {
                            Log.d("TestWeatherApp", response.message());
                            Toast.makeText(MainActivity.this, response.message() + " the city", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.cancel();
                    }

                    @Override
                    public void onFailure(Call<WeatherRoot> call, Throwable t) {
                        Log.d("TestWeatherApp", call.toString() + " " + t.getMessage());
                        progressDialog.cancel();
                    }
                });
    }

    private void updateUI(WeatherRoot weather) {
        TextView temp = findViewById(R.id.tvCityName);
        temp.setText(weather.name);
        temp = findViewById(R.id.tvTemp);
        String output = String.format("%2.0f\u2103", weather.main.temp);
        temp.setText(output);
        temp = findViewById(R.id.tvMinMax);
        output = String.format("Max.%-2.0f\u2103  Min.%-2.0f\u2103", weather.main.tempMin, weather.main.tempMax);
        temp.setText(output);
        temp = findViewById(R.id.tvMainWeather);
        temp.setText(weather.weather.get(0).main);
        temp = findViewById(R.id.tvDesc);
        temp.setText(weather.weather.get(0).description);
        temp = findViewById(R.id.tvHumidity);
        output = String.format("%-2.0f%%\nHumidity", weather.main.humidity);
        temp.setText(output);
        temp = findViewById(R.id.tvCloudCoverage);
        output = String.format("%-2.0f%%\nCloudy", weather.clouds.all);
        temp.setText(output);
    }

    public void getWeather(View view) {
        Log.d("TestWeatherApp", "start...");
        EditText etCity = findViewById(R.id.etCityName);
        getWeather(etCity.getText().toString());
    }

    public interface WeatherInterface {
        @GET("/data/2.5/weather")
        Call<WeatherRoot> getWeather(@Query("q") String cityName, @Query("appid") String appId
                , @Query("units") String unit);
    }

}