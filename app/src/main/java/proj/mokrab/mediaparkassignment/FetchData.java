package proj.mokrab.mediaparkassignment;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import proj.mokrab.mediaparkassignment.Model.Car;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FetchData extends AsyncTask<Void, Void, List<Car>> {

    private static Retrofit retrofit;
    private List<Car> carList = new ArrayList<>();

    @Override
    protected List<Car> doInBackground(Void... voids) {

        ApiAvailableCars api = getRetrofitInstance().create(ApiAvailableCars.class);
        Call<List<Car>> call = api.getAvailableCars();

        try {
            carList = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("FetchData", "carList: " + carList.get(0).getPlateNumber());

        return carList;
    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiAvailableCars.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }

}
