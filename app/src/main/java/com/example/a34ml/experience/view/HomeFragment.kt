package com.example.a34ml.experience.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.a34ml.R
import com.example.a34ml.databinding.ActivityMainBinding
import com.example.a34ml.databinding.FragmentHomeBinding
import com.example.a34ml.experience.viewmodel.ExperiencesViewModel
import com.example.a34ml.experience.viewmodel.ExperiencesViewModelFactory
import com.example.a34ml.model.experiencemodel.Experience
import com.example.a34ml.model.experiencemodel.ExperiencesRepository
import com.example.a34ml.network.experiencenetwork.ExperienceClient
import com.example.a34ml.utilities.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment(),OnExperienceClickListener {
    lateinit var experienceBinding: FragmentHomeBinding
    lateinit var viewModel: ExperiencesViewModel
    lateinit var experiencesFactory: ExperiencesViewModelFactory
    lateinit var experiencesAdapter: ExperienceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        experienceBinding =DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        experiencesAdapter = ExperienceAdapter(this)
        experienceBinding.apply {
            adapter=experiencesAdapter
            lifecycleOwner=this@HomeFragment
        }

        return experienceBinding.root
        //return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //experienceBinding.descriptinTv.text="Yeeees"
        experiencesFactory = ExperiencesViewModelFactory(
            ExperiencesRepository.getInstance(
                ExperienceClient.getInstance(),requireContext()
            )
        )
        viewModel = ViewModelProvider(this, experiencesFactory).get(ExperiencesViewModel::class.java)

        /*lifecycleScope.launch {
            viewModel.experiences.collect { result ->
                when (result) {
                    is ApiState.Success -> {
                        experienceBinding.apply {
                            // progressBar.visibility = View.GONE
                            recentRv.visibility = View.VISIBLE
                            experiencesAdapter.submitList(result.data)
                        }
                    }
                    is ApiState.Loading -> {
                        Log.i("Network", "onCreate: lading")
                        experienceBinding.apply {
                            // progressBar.visibility = View.GONE
                            recentRv.visibility = View.GONE
                        }

                    }
                    is ApiState.Failure -> {
                        Log.i("Network", "onCreate: faild")
                        withContext(Dispatchers.Main)
                        {
                            Toast.makeText(
                                requireContext(),
                                "Check your Connection",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                }
            }
        }*/
        lifecycleScope.launch {
            viewModel.recommendedExperiences.collect { result ->
                when (result) {
                    is ApiState.Success -> {
                        experienceBinding.apply {
                            // progressBar.visibility = View.GONE
                            recommendedRv.visibility = View.VISIBLE
                            experiencesAdapter.submitList(result.data)
                        }
                    }
                    is ApiState.Loading -> {
                        Log.i("Network", "onCreate: lading")
                        experienceBinding.apply {
                            // progressBar.visibility = View.GONE
                            recommendedRv.visibility = View.GONE
                        }

                    }
                    is ApiState.Failure -> {
                        Log.i("Network", "onCreate: faild")
                        withContext(Dispatchers.Main)
                        {
                            Toast.makeText(
                                requireContext(),
                                "Check your Connection",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                }
            }
        }


    }

    override fun onCardClick(experience: Experience) {
        Toast.makeText(
            requireContext(),
            "${experience.title}",
            Toast.LENGTH_SHORT
        ).show()
        val action = HomeFragmentDirections.actionHomeFragmentToExperienceDetailsFragment(experience)
        findNavController().navigate(action)
    }


}