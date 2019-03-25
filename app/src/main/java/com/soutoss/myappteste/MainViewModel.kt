package com.soutoss.myappteste

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(val source: RepoSource) : ViewModel() {

    val text: MutableLiveData<String> = MutableLiveData<String>().apply { value = "some" }


    fun updateName(){
        text.postValue(source.getName())
    }


}