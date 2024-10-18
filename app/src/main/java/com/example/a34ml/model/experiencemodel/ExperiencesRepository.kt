package com.example.a34ml.model.experiencemodel

import android.content.Context
import android.util.Log
import com.example.a34ml.network.experiencenetwork.IExperienceRemoteSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

class ExperiencesRepository(var remoteSource: IExperienceRemoteSource, private val context: Context): IExperiencesRepository {

    companion object
    {
        private var instance: ExperiencesRepository?=null
        fun getInstance(
            remoteSource: IExperienceRemoteSource,context: Context
        ): ExperiencesRepository {
            return instance ?: synchronized(this){
                val temp= ExperiencesRepository(remoteSource,context)
                instance =temp
                temp
            }
        }

    }

    /*override suspend fun getCharactersFromNetwork(): Flow<List<Character>> {

        if (!NetworkUtils.isNetworkAvailable(context)) {
            return flow { throw Exception("No internet connection") }
        }

        return remoteSource.getCharactersFromNetwork()
            .catch { e ->
                Log.e("REPO", "getCharactersFromNetwork: ${e.message}", e)
                throw e
            }
    }*/

    override suspend fun getRecentExperienceFromNetwork(): Flow<List<Experience>> {
        return remoteSource.getRecentExperienceFromNetwork()
            .catch { e ->
                Log.e("REPO", "getRecentExperienceFromNetwork: ${e.message}", e)
                throw e
            }
    }

    override suspend fun getRecommendedExperienceFromNetwork(): Flow<List<Experience>> {
        return remoteSource.getRecommendedExperienceFromNetwork()
            .catch { e ->
                Log.e("REPO", "getRecommendedExperienceFromNetwork: ${e.message}", e)
                throw e
            }
    }

    override suspend fun getSearchResultExperienceFromNetwork(query: String): Flow<List<Experience>> {
        return remoteSource.getSearchResultExperienceFromNetwork(query)
            .catch { e ->
                Log.e("REPO", "getSearchResultExperienceFromNetwork: ${e.message}", e)
                throw e
            }
    }

    override suspend fun postLiketoNetwork(id: String): Flow<Int> {
        return remoteSource.postLiketoNetwork(id)
            .catch { e ->
                Log.e("REPO", "postLiketoNetwork: ${e.message}", e)
                throw e
            }
    }

    override suspend fun getExperienceByIDFromNetwork(id: String): Flow<Experience> {
        return remoteSource.getExperienceByIDFromNetwork(id)
            .catch { e ->
                Log.e("REPO", "getExperienceByIDFromNetwork: ${e.message}", e)
                throw e
            }
    }

}



