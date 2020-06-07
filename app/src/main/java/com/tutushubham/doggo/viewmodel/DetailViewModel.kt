package com.tutushubham.doggo.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.tutushubham.doggo.model.DogBreed
import com.tutushubham.doggo.model.DogDatabase
import kotlinx.coroutines.launch


class DetailViewModel(application: Application) : BaseViewModel(application) {

    val dogLiveData = MutableLiveData<DogBreed>()//livedata created

    fun fetch(uuid: Int) {
        launch {
            val dog = DogDatabase(getApplication()).dogDao().getDog(uuid)
            dogLiveData.value = dog
        }
    }

}