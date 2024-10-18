package com.example.a34ml.experience.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a34ml.R
import com.example.a34ml.databinding.ItemExperienceBinding
import com.example.a34ml.model.experiencemodel.Experience

class ExperienceAdapter(var listener: OnExperienceClickListener,var likeListener: OnLikeClickListener, val showRecomendedLayout: Boolean)
    : ListAdapter<Experience, ExperienceAdapter.ViewHolder>(ExperienceDiffUtil()) {

    private var lastLikedItemId: String? = null


    fun updateExperience(updatedExperience: Experience) {
        val currentList = currentList.toMutableList()
        val position = currentList.indexOfFirst { it.id == updatedExperience.id }
        if (position != -1) {
            updatedExperience.is_liked=true
            currentList[position] = updatedExperience
            submitList(currentList)
        }
    }

    class ViewHolder(var experienceBinding:ItemExperienceBinding): RecyclerView.ViewHolder(experienceBinding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowContentBinding: ItemExperienceBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_experience,parent,false)
        return ViewHolder(rowContentBinding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentExperience=getItem(position)
        holder.experienceBinding.apply {
            experience=currentExperience
            action=listener
            likePressed=likeListener
            recommendedLayout.visibility = if (showRecomendedLayout) View.VISIBLE else View.GONE
            /*likeIcon.setOnClickListener {
                lastLikedItemId = currentExperience.id // Store the ID of the liked item
                Log.e("adapter", "onBindView:${lastLikedItemId}")

                if (currentExperience.is_liked!= true) {
                    likeListener.onLikeClick(currentExperience.id)
                }
            }*/

            likeIcon.setImageResource(
                if (currentExperience.is_liked == true) R.drawable.heart
                else R.drawable.heart_outline
            )
            likesCount.text = currentExperience.likes_no.toString()
            likeIcon.isEnabled = currentExperience.is_liked != true
            /*likeIcon.setOnClickListener {
                if (currentExperience.is_liked == true) {
                    likePressed.onLikeClick(currentExperience.id)
                    currentExperience.is_liked = true
                    notifyItemChanged(position)
                }
                likeIcon.isEnabled = currentExperience.is_liked == true
            }
            likeIcon.setImageResource(
                if (currentExperience.is_liked == true) R.drawable.heart
                else R.drawable.heart_outline
            )*/
        }


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

