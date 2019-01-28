package proj.mokrab.mediaparkassignment;

import java.util.List;

import proj.mokrab.mediaparkassignment.Model.Car;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiAvailableCars {

    String BASE_URL = "https://development.espark.lt/";

    @GET("api/mobile/public/availablecars")
    Call<List<Car>> getAvailableCars();
}
