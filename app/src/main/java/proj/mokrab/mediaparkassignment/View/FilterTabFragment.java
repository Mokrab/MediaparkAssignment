package proj.mokrab.mediaparkassignment.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import proj.mokrab.mediaparkassignment.R;
import proj.mokrab.mediaparkassignment.ViewModel.MainViewModel;

public class FilterTabFragment extends Fragment implements View.OnClickListener {

        private Button setFilter;
        private Button resetFilter;
        private EditText plateNumberValue;
        private MainViewModel mMainViewModel;
        private View view;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.filter_tab_fragment, container, false);

        setFilter = view.findViewById(R.id.button_setFilter);
        resetFilter = view.findViewById(R.id.button_resetFilter);
        plateNumberValue = view.findViewById(R.id.editText_plateinput);

        setFilter.setOnClickListener(this);
        resetFilter.setOnClickListener(this);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.init();



        return view;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_setFilter:{

                break;
            }
            case R.id.button_resetFilter:{

                break;
            }
        }




    }
}
