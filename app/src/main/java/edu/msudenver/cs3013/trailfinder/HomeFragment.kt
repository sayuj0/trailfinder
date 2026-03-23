package edu.msudenver.cs3013.trailfinder

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.exploreButton).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_trailListFragment)
        }
    }
}