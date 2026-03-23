package edu.msudenver.cs3013.trailfinder

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class TrailDetailFragment : Fragment(R.layout.fragment_trail_detail) {

    private val viewModel: TrailViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val trail = viewModel.getTrailById(0)

        trail?.let {
            view.findViewById<TextView>(R.id.detailName).text = it.name
            view.findViewById<TextView>(R.id.detailLocation).text = it.location
            view.findViewById<TextView>(R.id.detailDistance).text = it.distance
            view.findViewById<TextView>(R.id.detailDifficulty).text = it.difficulty
            view.findViewById<TextView>(R.id.detailDescription).text = it.description
        }
    }
}