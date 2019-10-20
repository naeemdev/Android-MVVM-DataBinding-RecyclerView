package com.android_mvvm_databinding_recyclerviewexample.CustomAdatper;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.android_mvvm_databinding_recyclerviewexample.Model.DeveloperModel;
import com.android_mvvm_databinding_recyclerviewexample.R;
import com.android_mvvm_databinding_recyclerviewexample.databinding.SingleListItemBinding;

import java.util.ArrayList;

public class Developer_CustomAdapter
        extends RecyclerView.Adapter<Developer_CustomAdapter.DeveloperViewHolder> {

    private ArrayList<DeveloperModel> mDeveloperModel;

    @NonNull
    @Override
    public DeveloperViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        SingleListItemBinding mDeveloperListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.single_list_item, viewGroup, false);

        return new DeveloperViewHolder(mDeveloperListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperViewHolder mDeveloperViewHolder, int i) {
        DeveloperModel currentStudent = mDeveloperModel.get(i);
        mDeveloperViewHolder.mDeveloperListItemBinding.setDeveloperModel(currentStudent);
    }

    @Override
    public int getItemCount() {
        if (mDeveloperModel != null) {
            return mDeveloperModel.size();
        } else {
            return 0;
        }
    }

    public void setDeveloperList(ArrayList<DeveloperModel> mDeveloperModel) {
        this.mDeveloperModel = mDeveloperModel;
        notifyDataSetChanged();
    }

    class DeveloperViewHolder extends RecyclerView.ViewHolder {

        SingleListItemBinding mDeveloperListItemBinding;


        public DeveloperViewHolder(@NonNull SingleListItemBinding mDeveloperListItemBinding) {
            super(mDeveloperListItemBinding.getRoot());

            this.mDeveloperListItemBinding = mDeveloperListItemBinding;
        }
    }
}
