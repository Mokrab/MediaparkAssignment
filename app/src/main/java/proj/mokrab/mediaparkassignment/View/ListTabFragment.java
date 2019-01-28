package proj.mokrab.mediaparkassignment.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import proj.mokrab.mediaparkassignment.Model.Car;
import proj.mokrab.mediaparkassignment.R;
import proj.mokrab.mediaparkassignment.ViewModel.MainViewModel;

public class ListTabFragment extends Fragment {
    private static final String TAG = "ListTabFragment";

    private MainViewModel mMainViewModel;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_tab_fragment, container, false);
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.init();

        mMainViewModel.getCars().observe(this, new Observer<List<Car>>() {
                        @Override
            public void onChanged(@Nullable List<Car> cars) {
                Log.d(TAG, "DATA: " + mMainViewModel.getCars().getValue().toString());

                mRecyclerViewAdapter.updateList(mMainViewModel.getCars().getValue());
            }
        });



        mRecyclerView = view.findViewById(R.id.RecyclerView_Main2);
        mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity(), mMainViewModel.getCars().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        return view;


    }

    @Override
    public void onResume() {

        super.onResume();

    }
}
