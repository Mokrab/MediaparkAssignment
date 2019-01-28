package proj.mokrab.mediaparkassignment.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import java.util.List;

import proj.mokrab.mediaparkassignment.Model.Car;
import proj.mokrab.mediaparkassignment.Repositories.CarsRepository;

public class MainViewModel extends ViewModel {

    // https://development.espark.lt/api/mobile/public/availablecars

    private MutableLiveData<List<Car>> mCars;
    private CarsRepository mRepository;

    public void init() {
        if (mCars != null) {
            return;
        }

        mRepository = CarsRepository.getInstance();
        mCars = mRepository.getCars();
        Log.d("MainViewModel", "test: " + mCars.getValue().toString());

    }


    public LiveData<List<Car>> getCars() {

        return mCars;

    }


}
