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

    override suspend fun getExperienceFromNetwork(): Flow<List<Experience>> {
        return remoteSource.getExperienceFromNetwork()
            .catch { e ->
                Log.e("REPO", "getExperienceFromNetwork: ${e.message}", e)
                throw e
            }
    }
    /*Log.i(
        "REPO",
        "getRecipesFromNetwork: repo ${remoteSource.getCharactersFromNetwork()}"
    )

    return remoteSource.getCharactersFromNetwork()*/
    }



