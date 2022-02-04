package com.example.activitylifecicle_lifecicleobserver

import androidx.lifecycle.LiveData

class MyLiveData: LiveData<String>() {

    fun setValueToLiveData(str: String){
        value = str
    }

    override fun onActive() {
        super.onActive()
        print("onActive")
    }

    override fun onInactive() {
        super.onInactive()
        print("onInactive")
    }
}