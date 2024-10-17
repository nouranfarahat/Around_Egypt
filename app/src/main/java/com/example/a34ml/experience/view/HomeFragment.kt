package com.example.a34ml.experience.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a34ml.R
import com.example.a34ml.databinding.ActivityMainBinding
import com.example.a34ml.experience.viewmodel.ExperiencesViewModel
import com.example.a34ml.experience.viewmodel.ExperiencesViewModelFactory


class HomeFragment : Fragment() {
    lateinit var experienceBinding: ActivityMainBinding
    lateinit var viewModel: ExperiencesViewModel
    lateinit var experiencesFactory: ExperiencesViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}