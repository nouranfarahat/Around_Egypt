package com.example.a34ml.experiencedetails.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.a34ml.R
import com.example.a34ml.databinding.FragmentExperienceDetailsBinding
import com.example.a34ml.databinding.FragmentHomeBinding
import com.example.a34ml.experience.view.ExperienceAdapter
import com.example.a34ml.experience.view.HomeFragmentDirections
import com.example.a34ml.model.experiencemodel.Experience

class ExperienceDetailsFragment : Fragment() {
    lateinit var experienceDetailsBinding: FragmentExperienceDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        experienceDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_experience_details, container, false)
        val experienceDetails: Experience? = ExperienceDetailsFragmentArgs.fromBundle(requireArguments()).experienceDetails

        experienceDetailsBinding.apply {
            experience=experienceDetails
            lifecycleOwner=this@ExperienceDetailsFragment
        }

        return experienceDetailsBinding.root
        //return inflater.inflate(R.layout.fragment_experience_details, container, false)
    }

}