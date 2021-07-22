package com.jeygm.platziconf.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.jeygm.platziconf.R
import com.jeygm.platziconf.model.Location
import kotlinx.android.synthetic.main.fragment_location_detail_dialog.*


class LocationDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FulScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tbLocation.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        tbLocation.setTitleTextColor(Color.WHITE)
        tbLocation.setNavigationOnClickListener { dismiss() }

        val location = Location()

        tbLocation.title = location.name

        tvLocationName.text = location.name
        tvPlatziConfAddress.text = location.address
        tvPlatziConfPhoneNum.text = location.phone
        tvPlatziConfWebsite.text = location.website


        tvPlatziConfAddress.setOnClickListener {
            
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=${location.address}")
                setPackage("com.google.android.apps.maps")
            }
            startActivity(intent)
        }

        tvPlatziConfPhoneNum.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${location.phone}")
            }
            startActivity(intent)
        }
        tvPlatziConfWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(location.website)
            }
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

    }
}