package edu.msudenver.cs3013.trailfinder

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

class TrailListFragment : Fragment(R.layout.fragment_trail_list) {

    private val viewModel: TrailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonIds = listOf(R.id.trail1, R.id.trail2, R.id.trail3, R.id.trail4)

        viewModel.trails.observe(viewLifecycleOwner) { trails ->
            buttonIds.forEachIndexed { index, buttonId ->
                val trail = trails[index]
                val button = view.findViewById<Button>(buttonId)
                button.text = trail.name
                button.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_trailListFragment_to_trailDetailFragment
                    )
                }
                Log.d("TrailFinder", "Trail loaded: ${trail.name}")
            }
        }
    }
}