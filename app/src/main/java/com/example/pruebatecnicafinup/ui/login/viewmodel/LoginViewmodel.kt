package com.example.pruebatecnicafinup.ui.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicafinup.base.BaseViewModel
import com.example.pruebatecnicafinup.data.BankDataService
import com.example.pruebatecnicafinup.ui.login.model.LoginRequest
import com.example.pruebatecnicafinup.ui.login.model.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: BaseViewModel() {

    val service = BankDataService()

    private var _loginObserver = MutableLiveData<LoginResponse>()
    val loginObserver: LiveData<LoginResponse> = _loginObserver

    fun login(request: LoginRequest){
        val request = service.login(request)
        request.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                _loginObserver.value = response.body()
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _failureObserver.value = t.message
            }

        })

    }

}