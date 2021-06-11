package com.example.finalpahrul.features.base

import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
    }

}