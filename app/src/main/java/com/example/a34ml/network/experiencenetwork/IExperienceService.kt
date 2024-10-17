package com.example.a34ml.network.experiencenetwork

import com.example.a34ml.model.experiencemodel.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface IExperienceService {

    @GET("api/v2/experiences")
    suspend fun getExperiences():ApiResponse //Response<ApiResponse>
    //@GET("people/{character_id}")
    //suspend fun getCharacterInfo(@Path("character_id") id:Long): Response<Character> //Response<Character> //ProductResponse

}