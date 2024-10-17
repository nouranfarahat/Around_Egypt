package com.example.a34ml.network.experiencenetwork

import com.example.a34ml.model.experiencemodel.Experience
import kotlinx.coroutines.flow.Flow

interface IExperienceRemoteSource {

    suspend fun getExperienceFromNetwork(): Flow<List<Experience>>
}