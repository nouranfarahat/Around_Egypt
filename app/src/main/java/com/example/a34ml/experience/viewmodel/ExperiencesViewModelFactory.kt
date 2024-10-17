package com.example.a34ml.experience.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a34ml.model.experiencemodel.IExperiencesRepository

class ExperiencesViewModelFactory(private val repo: IExperiencesRepository):
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(ExperiencesViewModel::class.java))
        {
            ExperiencesViewModel(repo) as T
        }
        else
        {
            throw IllegalStateException("ViewModel Class not found")
        }
    }
}