package com.example.pruebatecnicafinup.data

import com.example.pruebatecnicafinup.ui.login.model.LoginRequest
import com.example.pruebatecnicafinup.ui.login.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BankApi {

    @POST("user/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

}