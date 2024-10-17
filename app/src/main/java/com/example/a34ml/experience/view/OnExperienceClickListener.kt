package com.example.a34ml.experience.view

import com.example.a34ml.model.experiencemodel.Experience


//This interface to handle any clicks in the future
interface OnExperienceClickListener {
    fun onCardClick(experience: Experience)

}