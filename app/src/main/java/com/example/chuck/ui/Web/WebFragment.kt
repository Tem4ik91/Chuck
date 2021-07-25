package com.example.chuck.ui.Web

import android.R.layout
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chuck.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_jokes.*
import kotlinx.android.synthetic.main.fragment_web.*


class WebFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_web, container, false)

        val mWebView = rootView.findViewById<View>(R.id.web_View) as WebView
        val webSettings = mWebView.settings
        webSettings.javaScriptEnabled = true
        mWebView.loadUrl("https://www.icndb.com/api/")
        return rootView
    }


    override fun onDestroyView() {
        super.onDestroyView()

    }

}

