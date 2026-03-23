package edu.msudenver.cs3013.trailfinder

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TrailListFragment : Fragment(R.layout.fragment_trail_list) {

    private val viewModel: TrailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TrailAdapter { trail ->
            val action =
                TrailListFragmentDirections.actionTrailListFragmentToTrailDetailFragment(trail.id)
            findNavController().navigate(action)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.trailRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.trails.observe(viewLifecycleOwner) { trails ->
            adapter.submitList(trails)
        }
    }
}