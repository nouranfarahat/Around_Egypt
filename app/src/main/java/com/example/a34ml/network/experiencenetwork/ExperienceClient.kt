package com.example.a34ml.network.experiencenetwork


import android.util.Log
import com.example.a34ml.model.experiencemodel.Experience
import com.example.a34ml.network.RetrofitHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ExperienceClient: IExperienceRemoteSource {

    val experienceService: IExperienceService by lazy {
        RetrofitHelper.retrofitInstance.create(IExperienceService::class.java)
    }
    companion object
    {
        private var instance: ExperienceClient?=null
        fun getInstance(): ExperienceClient {
            return instance ?: synchronized(this){
                val temp= ExperienceClient()
                instance =temp
                temp
            }
        }

    }

    override suspend fun getRecentExperienceFromNetwork(): Flow<List<Experience>> =flow {
        val experiences = experienceService.getRecentExperiences().data?: listOf()
        Log.i("NET", "getExperienceFromNetwork: client ${experiences.get(1).description}")

        emit(experiences)
    }

    override suspend fun getRecommendedExperienceFromNetwork(): Flow<List<Experience>>  =flow {
        val experiences = experienceService.getRecommendedExperiences().data
        Log.i("NET", "getRecommendedExperienceFromNetwork: client ${experiences.get(1).description}")

        emit(experiences)
    }

    override suspend fun getSearchResultExperienceFromNetwork(query: String): Flow<List<Experience>> =flow {
        val searchResultExperiences = experienceService.getSearchExperiences(query).data
        Log.i("NET", "getSearchResultExperienceFromNetwork: client ${searchResultExperiences.get(0).description}")

        emit(searchResultExperiences)
    }

    override suspend fun postLiketoNetwork(id: String): Flow<Int> =flow{
        val likeCount= experienceService.likeExperience(id).body()?.data
        if (likeCount != null) {
            emit(likeCount)
        }
    }

    override suspend fun getExperienceByIDFromNetwork(id: String): Flow<Experience> =flow {
        val experience = experienceService.getByIdExperience(id).data
        Log.i("NET", "getRecommendedExperienceFromNetwork: client ${experience.description}")

        emit(experience)
    }


}