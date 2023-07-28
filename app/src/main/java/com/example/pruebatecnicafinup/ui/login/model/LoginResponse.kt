package com.example.pruebatecnicafinup.ui.login.model

data class LoginResponse(
    val id: Int,
    val userName: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val token: String,
    val message: String,
    val result: Boolean
)
