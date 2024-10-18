package com.example.a34ml.model.experiencemodel

import java.io.Serializable
data class LikeResponse(
    val meta: Meta,
    val data: Int,
    val pagination: Pagination
): Serializable
data class ApiResponse(
    val meta: Meta,
    val data: List<Experience>,
    val pagination: Pagination
): Serializable
data class Meta(
    val code: Int,
    val errors: List<String>
): Serializable
data class ExperienceResponse(
    val meta: Meta,
    val data: Experience,
    val pagination: Pagination
): Serializable
data class Experience(
    val id: String,
    val title: String,
    val cover_photo: String,
    val description: String,
    val views_no: Int,
    val likes_no: Int,
    val recommended: Int,
    val has_video: Int,
    val tags: List<Tag>,
    val city: City,
    val tour_html: String,
    val famous_figure: String,
    val period: Period?,
    val era: Era?,
    val founded: String,
    val detailed_description: String,
    val address: String,
    val gmap_location: GmapLocation,
    val opening_hours: Map<String, List<String>>,
    val translated_opening_hours: Map<String, TranslatedOpeningHours>,
    val starting_price: Int?,
    val ticket_prices: List<TicketPrice>,
    val experience_tips: List<Any>,
    var is_liked: Boolean?,
    val reviews: List<Review>,
    val rating: Int,
    val reviews_no: Int,
    val audio_url: String,
    val has_audio: Boolean
): Serializable
data class Tag(
    val id: Int,
    val name: String,
    val disable: Any?,
    val top_pick: Int
): Serializable

data class City(
    val id: Int,
    val name: String,
    val disable: Any?,
    val top_pick: Int
): Serializable

data class Period(
    val id: String,
    val value: String,
    val created_at: String,
    val updated_at: String
): Serializable

data class Era(
    val id: String,
    val value: String,
    val created_at: String,
    val updated_at: String
): Serializable
data class GmapLocation(
    val type: String,
    val coordinates: List<Double>
): Serializable

data class TranslatedOpeningHours(
    val day: String,
    val time: String
): Serializable

data class TicketPrice(
    val type: String,
    val price: Int
): Serializable

data class Review(
    val id: String,
    val experience: String,
    val name: String,
    val rating: Int,
    val comment: String,
    val created_at: String
): Serializable

data class Pagination(val id: String)