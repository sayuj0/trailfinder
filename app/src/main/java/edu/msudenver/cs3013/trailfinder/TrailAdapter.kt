package edu.msudenver.cs3013.trailfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TrailAdapter(
    private val onTrailClick: (Trail) -> Unit
) : ListAdapter<Trail, TrailAdapter.TrailViewHolder>(DIFF_CALLBACK) {

    inner class TrailViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameView = itemView.findViewById<TextView>(R.id.trailItemName)
        private val locationView = itemView.findViewById<TextView>(R.id.trailItemLocation)
        private val distanceView = itemView.findViewById<TextView>(R.id.trailItemDistance)
        private val difficultyView = itemView.findViewById<TextView>(R.id.trailItemDifficulty)

        fun bind(trail: Trail) {
            nameView.text = trail.name
            locationView.text = trail.location
            distanceView.text = trail.distance
            difficultyView.text = trail.difficulty

            itemView.setOnClickListener {
                onTrailClick(trail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_trail, parent, false)
        return TrailViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Trail>() {
            override fun areItemsTheSame(oldItem: Trail, newItem: Trail): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Trail, newItem: Trail): Boolean =
                oldItem == newItem
        }
    }
}