package com.example.pruebatecnicafinup.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebatecnicafinup.ui.login.model.LoginResponse

open class BaseViewModel: ViewModel() {

    protected var _failureObserver = MutableLiveData<String>()
    val failureObserver: LiveData<String> = _failureObserver
}