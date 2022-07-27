package com.example.newtrainerapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newtrainerapp.dto.TrainerDto
import com.example.newtrainerapp.repository.ActivityRepository
import com.example.newtrainerapp.retrofit.models.BaseNetworkResult
import com.example.newtrainerapp.utils.SharedPref
import javax.inject.Inject

class ActivityViewModel @Inject constructor(
    private val activityRepository: ActivityRepository,
    private var sharedPreferencesHelper: SharedPref
) : ViewModel() {
    private val trainersList = MutableLiveData<List<TrainerDto>>()
    val trainersListLiveData: LiveData<List<TrainerDto>> get() = trainersList

    private val errorMessage = MutableLiveData<String>()
    val errorMessageLiveData: LiveData<String> get() = errorMessage

    fun getAllTrainers() {
        activityRepository.getAllTrainer().observeForever {
            when (it) {
                is BaseNetworkResult.Error -> {
                    it.message?.let { error ->
                        errorMessage.value = error
                    }
                }
                is BaseNetworkResult.Success -> {
                    it.data?.let { list ->
                        trainersList.value = list
                    }
                }
                else -> {}
            }
        }
    }
}