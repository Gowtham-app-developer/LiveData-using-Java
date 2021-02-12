package com.gowtham.livedata_recyclerview.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.gowtham.livedata_recyclerview.model.User;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    MutableLiveData<ArrayList<User>> userLiveData;
    ArrayList<User> userArrayList;

    public MainViewModel() {
        userLiveData = new MutableLiveData<>();

        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<User>> getUserMutableLiveData() {
        return userLiveData;
    }

    public void init(){
        populateList();
        userLiveData.setValue(userArrayList);
    }

    public void populateList(){

        User user = new User();
        user.setTitle("Android");
        user.setDescription("Google");

        User user1 = new User();
        user1.setTitle("React");
        user1.setDescription("Facebook");

        userArrayList = new ArrayList<>();
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user1);
        userArrayList.add(user1);
        userArrayList.add(user);
        userArrayList.add(user);
    }
}
