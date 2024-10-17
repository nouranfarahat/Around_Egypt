package com.example.a34ml.experience.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.a34ml.R
import com.example.a34ml.databinding.ActivityMainBinding
import com.example.a34ml.experience.viewmodel.ExperiencesViewModel
import com.example.a34ml.experience.viewmodel.ExperiencesViewModelFactory
import com.example.a34ml.model.experiencemodel.ExperiencesRepository
import com.example.a34ml.network.experiencenetwork.ExperienceClient
import com.example.a34ml.utilities.ApiState
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var experienceBinding:ActivityMainBinding
    lateinit var viewModel: ExperiencesViewModel
    lateinit var experiencesFactory: ExperiencesViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        experienceBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(experienceBinding.root)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //experienceBinding.descriptinTv.text="Yeeees"
        experiencesFactory = ExperiencesViewModelFactory(
            ExperiencesRepository.getInstance(
                ExperienceClient.getInstance(),baseContext
            )
        )
        viewModel = ViewModelProvider(this, experiencesFactory).get(ExperiencesViewModel::class.java)

        lifecycleScope.launch {
            viewModel.experiences.collect { result ->
                when (result) {
                    is ApiState.Success -> {
                        experienceBinding.apply {
                           // progressBar.visibility = View.GONE
                          experience=result.data.get(1)
                        }
                    }
                    is ApiState.Loading -> {
                        Log.i("Network", "onCreate: lading")
                        }
                    is ApiState.Failure -> {
                        Log.i("Network", "onCreate: faild")

            }
                }
            }
        }


    }
}