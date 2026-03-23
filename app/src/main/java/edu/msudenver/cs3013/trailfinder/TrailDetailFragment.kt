package edu.msudenver.cs3013.trailfinder

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs

class TrailDetailFragment : Fragment(R.layout.fragment_trail_detail) {

    private val args: TrailDetailFragmentArgs by navArgs()
    private val viewModel: TrailViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val trail = viewModel.getTrailById(args.trailId)

        trail?.let {
            view.findViewById<TextView>(R.id.detailName).text = it.name
            view.findViewById<TextView>(R.id.detailLocation).text = it.location
            view.findViewById<TextView>(R.id.detailDistance).text = "Distance: ${it.distance}"
            view.findViewById<TextView>(R.id.detailDifficulty).text = "Difficulty: ${it.difficulty}"
            view.findViewById<TextView>(R.id.detailDescription).text = it.description
        }
    }
}