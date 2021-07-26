package com.example.chuck.ui.Joke

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chuck.R
import com.example.chuck.databinding.FragmentJokesBinding
import kotlinx.android.synthetic.main.fragment_jokes.*
import kotlinx.android.synthetic.main.fragment_jokes.view.*

class JokesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootJokes = inflater.inflate(R.layout.fragment_jokes, container, false)

        rootJokes.btn_jokes.setOnClickListener {

            val count_Jokes = editText_jokes.text

            val jokesData = MutableList(count_Jokes.toString().toInt(), {x-> "$x"})
            val adapter =
                activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, jokesData) }
            list_jokes.adapter = adapter

        }


        return rootJokes
    }



    override fun onDestroyView() {
        super.onDestroyView()
      //  _binding = null
    }
}