package com.example.a34ml.network.experiencenetwork

import com.example.a34ml.model.experiencemodel.Experience
import com.example.a34ml.model.experiencemodel.LikeResponse
import kotlinx.coroutines.flow.Flow

interface IExperienceRemoteSource {

    suspend fun getRecentExperienceFromNetwork(): Flow<List<Experience>>
    suspend fun getRecommendedExperienceFromNetwork(): Flow<List<Experience>>
    suspend fun getSearchResultExperienceFromNetwork(query: String): Flow<List<Experience>>
    suspend fun postLiketoNetwork(id: String): Flow<Int>
    suspend fun getExperienceByIDFromNetwork(id:String): Flow<Experience>



}