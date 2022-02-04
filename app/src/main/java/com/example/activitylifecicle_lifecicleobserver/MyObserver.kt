package com.example.activitylifecicle_lifecicleobserver


import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleEventObserver

class MyObserver: LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d("TAG", event.name.toString())
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    fun myFun(source: LifecycleOwner, event: Lifecycle.Event){
//        Log.d("TAG", event.toString())
//    }
}

