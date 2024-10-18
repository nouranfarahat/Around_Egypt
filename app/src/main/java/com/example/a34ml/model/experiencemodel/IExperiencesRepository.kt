package com.example.a34ml.model.experiencemodel

import kotlinx.coroutines.flow.Flow

interface IExperiencesRepository {

    suspend fun getRecentExperienceFromNetwork(): Flow<List<Experience>>
    suspend fun getRecommendedExperienceFromNetwork(): Flow<List<Experience>>
    suspend fun getSearchResultExperienceFromNetwork(query: String): Flow<List<Experience>>
    suspend fun postLiketoNetwork(id: String): Flow<Int>
    suspend fun getExperienceByIDFromNetwork(id: String): Flow<Experience>




}