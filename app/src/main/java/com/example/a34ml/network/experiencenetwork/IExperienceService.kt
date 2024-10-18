package com.example.a34ml.network.experiencenetwork

import com.example.a34ml.model.experiencemodel.ApiResponse
import com.example.a34ml.model.experiencemodel.Experience
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface IExperienceService {

    @GET("api/v2/experiences")
    suspend fun getRecentExperiences():ApiResponse //Response<ApiResponse>
    @GET("api/v2/experiences")
    suspend fun getRecommendedExperiences(@Query("filter[recommended]") recommended: Boolean = true): ApiResponse

    @GET("api/v2/experiences")
    suspend fun getSearchExperiences(@Query("filter[title]") searchText: String): ApiResponse

    @GET("api/v2/experiences/{id}")
    suspend fun getExperience(@Path("id") id: String): Experience

    @POST("api/v2/experiences/{id}/like")
    suspend fun likeExperience(@Path("id") id: String): Response<Unit>

}