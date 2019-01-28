package proj.mokrab.mediaparkassignment.Repositories;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import proj.mokrab.mediaparkassignment.FetchData;
import proj.mokrab.mediaparkassignment.Model.Car;

public class CarsRepository {

    private static CarsRepository instance;
    private List<Car> mCarList = new ArrayList<>();

    private FetchData mFetchData = new FetchData();
    private boolean mFetchActive = false;

    public static CarsRepository getInstance() {
        if (instance == null) {
            instance = new CarsRepository();
        }
        return instance;
    }


    public MutableLiveData<List<Car>> getCars() {
        final MutableLiveData<List<Car>> data = new MutableLiveData<>();

        if (!mFetchActive) {
            fetchCarList();
        }

        data.setValue(mCarList);

        Log.d("CarsRepository", "DATA: " + data.getValue().toString());
        return data;
    }

    private void fetchCarList() {
        mFetchData.execute();
        try {
            mCarList = mFetchData.get();
            Log.d("CarsRepository", mCarList.toString());
            mFetchActive = true;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
