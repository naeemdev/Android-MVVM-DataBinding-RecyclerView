package com.android_mvvm_databinding_recyclerviewexample.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.android_mvvm_databinding_recyclerviewexample.Model.DeveloperModel;
import com.android_mvvm_databinding_recyclerviewexample.repository.DeveloperRepository;

import java.util.List;


public class DeveloperViewModel extends AndroidViewModel {
    private DeveloperRepository mDeveloperRepository;

    public DeveloperViewModel(@NonNull Application application) {
        super(application);
        mDeveloperRepository = new DeveloperRepository();
    }

    public LiveData<List<DeveloperModel>> getAllDeveloper() {
        return mDeveloperRepository.getMutableLiveData();
    }
}
