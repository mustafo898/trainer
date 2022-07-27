package com.example.newtrainerapp.ui

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newtrainerapp.controller.Extensions
import com.example.newtrainerapp.databinding.FragmentLoginBinding
import com.example.newtrainerapp.mvvm.ActivityViewModel
import com.example.newtrainerapp.retrofit.models.request.LogInRequest

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private lateinit var viewModel: ActivityViewModel

    override fun onViewCreated() {
        viewModel = ViewModelProvider(requireActivity())[ActivityViewModel::class.java]

        (activity as AppCompatActivity?)?.supportActionBar?.title = "Log In"

        binding.rLoginBtn.setOnClickListener {
            val username = binding.rUsername.text.toString()
            val password = binding.rPassword.text.toString()
            val request = LogInRequest(username, password)
            viewModel.logIn(request, requireContext())
            viewModel.correct.observe(requireActivity()) {
                if (it == true) {
                    Extensions.controller?.startMainFragment(TrainerFragment())
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Wrong username or password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            binding.rSignupBtn.setOnClickListener {
                Extensions.controller?.startMainFragment(SignUpFragment())
            }
        }
    }
}