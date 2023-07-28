package com.example.pruebatecnicafinup.extentions

import android.widget.EditText
import java.util.regex.Pattern

class EditTextExt {

    fun EditText.ValidCharacters() : Boolean{
        return Pattern.matches("[a-z]", text.toString())
    }
}