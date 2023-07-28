package com.example.pruebatecnicafinup.data


import com.example.pruebatecnicafinup.ui.login.model.LoginRequest
import com.example.pruebatecnicafinup.ui.login.model.LoginResponse
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class BankDataService {

    val gson = GsonBuilder().create()
    val retrofit = Retrofit.Builder()
        .baseUrl("http://24.199.91.134:8080/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val api = retrofit.create(BankApi::class.java)

    fun login(request: LoginRequest) = api.login(request)

}