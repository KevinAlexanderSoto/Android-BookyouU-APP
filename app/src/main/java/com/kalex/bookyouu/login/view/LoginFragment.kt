package com.kalex.bookyouu.login.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.kalex.bookyouu.AdminActivity
import com.kalex.bookyouu.R
import com.kalex.bookyouu.databinding.LoginScreenFragmentBinding

import com.kalex.bookyouu.login.validation.isEmailValid
import com.kalex.bookyouu.login.validation.isPasswordEmpy

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: LoginScreenFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LoginScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

            setErrorListener(binding)
            loginButton.setOnClickListener {
                var emailIsValid = emailTextInput.editText?.isEmailValid() ?: false
                var passwordValid = passwordTextInput.editText?.isPasswordEmpy() ?:false
                if (emailIsValid  &&  passwordValid){
                    val sendIntent = Intent(activity, AdminActivity::class.java)
                    activity?.startActivity(sendIntent)
                    activity?.finish()
                }else{
                    emailTextInput.error = resources.getString(R.string.login_credentials_error)
                    passwordTextInput.error =  resources.getString(R.string.login_credentials_error)
                }
            }

        }
    }
    private fun setErrorListener(binding : LoginScreenFragmentBinding){
        binding.emailTextInput.editText?.doOnTextChanged { text, start, before, count ->
            binding.emailTextInput.error = null
        }
        binding.passwordTextInput.editText?.doOnTextChanged { text, start, before, count ->
            binding.passwordTextInput.error = null
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}