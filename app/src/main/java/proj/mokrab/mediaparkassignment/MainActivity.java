package proj.mokrab.mediaparkassignment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewParent;

import proj.mokrab.mediaparkassignment.View.FilterTabFragment;
import proj.mokrab.mediaparkassignment.View.ListTabFragment;
import proj.mokrab.mediaparkassignment.View.MapTabFragment;
import proj.mokrab.mediaparkassignment.View.RecyclerViewAdapter;
import proj.mokrab.mediaparkassignment.View.SectionsPageAdapter;
import proj.mokrab.mediaparkassignment.ViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter adapter;
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Activity Starting.");


        adapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);




    }


    private void setupViewPager(ViewPager viewPager){
        adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ListTabFragment(), "List");
        adapter.addFragment(new MapTabFragment(), "Map");
        adapter.addFragment(new FilterTabFragment(), "Filter");
        viewPager.setAdapter(adapter);
    }


}
