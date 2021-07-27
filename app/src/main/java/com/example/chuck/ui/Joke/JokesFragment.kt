package com.example.chuck.ui.Joke


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.chuck.R
import kotlinx.android.synthetic.main.fragment_jokes.*
import kotlinx.android.synthetic.main.fragment_jokes.view.*
import okhttp3.*
import org.json.JSONObject

class JokesFragment : Fragment() {

    var okHttpClient: OkHttpClient = OkHttpClient()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootJokes = inflater.inflate(R.layout.fragment_jokes, container, false)


        rootJokes.btn_jokes.setOnClickListener {
            if (editText_jokes.text.isNotEmpty()) {
                loadRandomFact()
            }
        }

        return rootJokes
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun loadRandomFact() {


        val count_Jokes = editText_jokes.text
        val URL = "https://api.icndb.com/jokes/random/$count_Jokes"

        val request: Request = Request.Builder().url(URL).build()
        okHttpClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: java.io.IOException) {}

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {

                    val json = response.body?.string()

                    val result = JSONObject(json)
                    val rows = result.getJSONArray("value")
                    val id = rows.getJSONObject(0)
                    val joke = id.getString("joke")

                    val availabilityArray = MutableList(count_Jokes.toString().toInt()) {
                        joke
                    }

                    val adapter =
                        activity?.let {
                            ArrayAdapter<String>(
                                it,
                                android.R.layout.simple_list_item_1,
                                availabilityArray
                            )
                        }

                    activity?.runOnUiThread {
                        list_jokes.adapter = adapter
                    }

                }

            }

        })


    }

}
