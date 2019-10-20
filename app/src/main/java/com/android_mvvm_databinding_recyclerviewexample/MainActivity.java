package com.android_mvvm_databinding_recyclerviewexample;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android_mvvm_databinding_recyclerviewexample.CustomAdatper.Developer_CustomAdapter;
import com.android_mvvm_databinding_recyclerviewexample.databinding.ActivityMainBinding;
import com.android_mvvm_databinding_recyclerviewexample.model.DeveloperModel;
import com.android_mvvm_databinding_recyclerviewexample.viewmodel.DeveloperViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ProgressBar loadBar;
    private DeveloperViewModel mainViewModel;
    private Developer_CustomAdapter mDeveloper_CustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        // bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.viewdeveloper;
        loadBar = activityMainBinding.loadBar;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ///init the View Model
        mainViewModel = ViewModelProviders.of(this).get(DeveloperViewModel.class);

        //init the Custom adataper
        mDeveloper_CustomAdapter = new Developer_CustomAdapter();
        //set the CustomAdapter
        recyclerView.setAdapter(mDeveloper_CustomAdapter);

        getAllDev();
    }

    private void getAllDev() {
        ///get the list of dev from api response
        mainViewModel.getAllDeveloper().observe(this, new Observer<List<DeveloperModel>>() {
            @Override
            public void onChanged(@Nullable List<DeveloperModel> mDeveloperModel) {

                ///if any thing chnage the update the UI
                mDeveloper_CustomAdapter.setDeveloperList((ArrayList<DeveloperModel>) mDeveloperModel);
                loadBar.setVisibility(View.GONE);
            }
        });
    }
}
