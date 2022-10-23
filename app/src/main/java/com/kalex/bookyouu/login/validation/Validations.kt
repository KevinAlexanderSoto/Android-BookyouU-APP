package com.kalex.bookyouu.login.validation


import android.util.Log
import android.widget.EditText
import java.util.regex.Pattern

private val EMAIL_REGEX = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})\$"

fun EditText.isEmailValid() : Boolean{
    return Pattern.matches(EMAIL_REGEX,this.text.toString())
}

fun EditText.isPasswordEmpy() : Boolean{
    return if (this.text.toString().isEmpty()){
        false
    }else
    {
        Log.d("Login",this.text.toString())
        true
    }
}