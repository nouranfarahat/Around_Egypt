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

    override suspend fun getExperienceFromNetwork(): Flow<List<Experience>> =flow {
        val experiences = experienceService.getExperiences().data?: listOf()
        Log.i("NET", "getExperienceFromNetwork: client ${experiences.get(1).description}")

        emit(experiences)
    }


    /*    override suspend fun getCharactersFromNetwork(): Flow<List<Character>> =flow {
            val characters = characterService.getAllCharacters().body()?.results?: listOf()
            Log.i("NET", "getCharactersFromNetwork: client ${characters.get(1).name}")

            emit(characters)
        }

        override suspend fun getCharacterInfoFromNetwork(id:Long): Flow<Character> =flow {
            val character = characterService.getCharacterInfo(id).body()

            if (character != null) {
                emit(character)
            }
        }*/


}