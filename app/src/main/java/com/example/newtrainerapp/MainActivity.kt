package com.example.newtrainerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newtrainerapp.controller.Extensions
import com.example.newtrainerapp.databinding.ActivityMainBinding
import com.example.newtrainerapp.di.component.AppComponent
import com.example.newtrainerapp.ui.SignUpFragment
import com.example.newtrainerapp.ui.TrainerFragment
import com.example.newtrainerapp.utils.SharedPref
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val shared by lazy {
        SharedPref(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Extensions.init(R.id.container, supportFragmentManager)

        if (shared.getToken() != "") {
            Extensions.controller?.startMainFragment(TrainerFragment())
        } else {
            Extensions.controller?.startMainFragment(SignUpFragment())
        }
    }
}