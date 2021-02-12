package com.gowtham.livedata_recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gowtham.livedata_recyclerview.adapter.RecyclerViewAdapter;
import com.gowtham.livedata_recyclerview.model.User;
import com.gowtham.livedata_recyclerview.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private MainActivity context;
    private MainViewModel viewModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        recyclerView = findViewById(R.id.rv_main);
        viewModel = ViewModelProviders.of(context).get(MainViewModel.class);
        viewModel.getUserMutableLiveData().observe(context, userListUpdateObserver);

    }


    Observer<ArrayList<User>> userListUpdateObserver = new Observer<ArrayList<User>>() {
        @Override
        public void onChanged(ArrayList<User> userArrayList) {
            recyclerViewAdapter = new RecyclerViewAdapter(context,userArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(recyclerViewAdapter);
        }
    };


}
