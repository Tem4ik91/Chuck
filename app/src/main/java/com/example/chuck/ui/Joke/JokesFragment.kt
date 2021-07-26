package com.example.chuck.ui.Joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chuck.R
import com.example.chuck.databinding.FragmentJokesBinding

class JokesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootJokes = inflater.inflate(R.layout.fragment_jokes, container, false)
        return rootJokes
    }


   /* override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    }*/

    override fun onDestroyView() {
        super.onDestroyView()
      //  _binding = null
    }
}