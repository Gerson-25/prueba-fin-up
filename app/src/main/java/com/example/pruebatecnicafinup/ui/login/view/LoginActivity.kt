package com.example.pruebatecnicafinup.ui.login.view

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.pruebatecnicafinup.R
import com.example.pruebatecnicafinup.databinding.LoginActivityBinding
import com.example.pruebatecnicafinup.ui.login.model.LoginRequest
import com.example.pruebatecnicafinup.ui.login.viewmodel.LoginViewModel
import java.util.regex.Pattern

class LoginActivity : ComponentActivity() {

    val viemodel: LoginViewModel by viewModels()

    lateinit var binding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            if (validateLogin()){
                val username = binding.username.text.toString()
                val password = binding.password.text.toString()
                binding.error.visibility = View.GONE
                login(username, password)
            } else {
                binding.error.visibility = View.VISIBLE
                binding.error.text = "Asegurate de completar los datos con la información correcta"
            }
        }

        viemodel.loginObserver.observe(this) {

        }
        viemodel.failureObserver.observe(this) {

        }

    }

    fun login(username: String, password: String){
        val request = LoginRequest(
            username,
            password
        )
        viemodel.login(request = request)
    }

    fun validateLogin(): Boolean {
        return validUserName() && passwordNotEmpty()
    }

    fun validUserName(): Boolean{
        return Pattern.matches("^[a-z]+\$", binding.username.text.toString())
    }

    fun passwordNotEmpty(): Boolean{
        return binding.password.text.isNotEmpty()
    }
}