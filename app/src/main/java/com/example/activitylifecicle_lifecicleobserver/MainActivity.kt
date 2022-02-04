package com.example.activitylifecicle_lifecicleobserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.activitylifecicle_lifecicleobserver.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var myObserver: MyObserver

    //private var liveDataStr = MutableLiveData<String>()

    private lateinit var binding: ActivityMainBinding

    private lateinit var myLiveData: MyLiveData

    lateinit var observer: Observer<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observer = Observer {
            binding.tw1.text = it
        }
        // Инициализируем LiveData
        myLiveData = MyLiveData()

        // Создаем наблюдатель
        observer = Observer {
            binding.tw1.text = it
        }
        //Подключаем наблюдатель
        myLiveData.observe(this, observer)

        //liveDataStr.value = "Hello Live Data"
        //binding.tw1.text = liveDataStr.value
        binding.button.setOnClickListener {
            //liveDataStr.value = binding.et.text.toString()
            myLiveData.setValueToLiveData(binding.et.text.toString())
        }

//        CoroutineScope(Dispatchers.IO).launch {
//            liveDataStr.postValue("Hello Live Data")
//        }
        myObserver = MyObserver()
        lifecycle.addObserver(myObserver)
    }

    private fun toastMeState(message: String) {
        Toast.makeText(this, "$message, ${lifecycle.currentState}", Toast.LENGTH_LONG)
    }
    // Удаляем наблюдатель
    override fun onStop() {
        super.onStop()
        myLiveData.removeObserver(observer)
    }
}