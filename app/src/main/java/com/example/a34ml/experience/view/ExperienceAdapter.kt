package com.example.a34ml.experience.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a34ml.R
import com.example.a34ml.databinding.ItemExperienceBinding
import com.example.a34ml.model.experiencemodel.Experience

class ExperienceAdapter(var listener: OnExperienceClickListener)
    : ListAdapter<Experience, ExperienceAdapter.ViewHolder>(ExperienceDiffUtil()) {

    class ViewHolder(var experienceBinding:ItemExperienceBinding): RecyclerView.ViewHolder(experienceBinding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowContentBinding: ItemExperienceBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_experience,parent,false)
        return ViewHolder(rowContentBinding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentExperience=getItem(position)
        holder.experienceBinding.experience=currentExperience
        holder.experienceBinding.action=listener
    }
}

class ExperienceDiffUtil: DiffUtil.ItemCallback<Experience>()
{
    override fun areItemsTheSame(oldItem: Experience, newItem: Experience): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Experience, newItem: Experience): Boolean {

        return oldItem==newItem
    }

}

