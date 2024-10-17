package com.example.a34ml.experience.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a34ml.model.experiencemodel.Experience
import com.example.a34ml.model.experiencemodel.IExperiencesRepository
import com.example.a34ml.utilities.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ExperiencesViewModel(private val repo: IExperiencesRepository) : ViewModel() {

    //Backing property
    private var _experiences = MutableStateFlow<ApiState<List<Experience>>>(ApiState.Loading)
    val experiences: StateFlow<ApiState<List<Experience>>>
        get() = _experiences

    //When the object of viewModel is created fetchCharacters is called to present the recipe list to the user
    init {
        fetchExperiences()
    }

     fun fetchExperiences() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getExperienceFromNetwork()
                .catch {

                    error->_experiences.value=ApiState.Failure(error)
                    Log.e("ViewModel", "fetchExperiences: ${error.message}", error)

                }
                .collect{
                    data->_experiences.value=ApiState.Success(data)
                    //check if the data arrived here
                    Log.i("ViewModel", "fetchExperiences: ${data[0].description}")
                }


        }
    }

}