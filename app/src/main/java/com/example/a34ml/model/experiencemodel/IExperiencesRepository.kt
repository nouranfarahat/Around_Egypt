package com.example.a34ml.model.experiencemodel

import kotlinx.coroutines.flow.Flow

interface IExperiencesRepository {

    suspend fun getExperienceFromNetwork(): Flow<List<Experience>>


}