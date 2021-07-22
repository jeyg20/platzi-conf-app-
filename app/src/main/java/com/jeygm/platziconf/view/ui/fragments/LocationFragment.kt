package com.jeygm.platziconf.view.ui.fragments

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.*
import com.jeygm.platziconf.R
import com.google.android.gms.maps.model.*
import com.jeygm.platziconf.model.Location


class LocationFragment : Fragment(), OnMapReadyCallback , GoogleMap.OnMarkerClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById((R.id.map)) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {

        val location = Location()

        val zoom = 16f
        val centerMap = LatLng(location.latitude, location.longitude)

        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(centerMap, zoom))

        val markerOptions = MarkerOptions()
        markerOptions.position(centerMap)
        markerOptions.title("Platzi conf 2018")

        val logoBitMap = context?.applicationContext?.let { ContextCompat.getDrawable(it, R.drawable.logo_platzi) } as BitmapDrawable
        val smallMarker = Bitmap.createScaledBitmap(logoBitMap.bitmap, 140, 140, false)

        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        googleMap.addMarker(markerOptions)

        googleMap?.setOnMarkerClickListener(this)

        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.custom_map))

    }

    override fun onMarkerClick(p0: Marker): Boolean {
        findNavController().navigate(R.id.locationDetailFragmentDialog)
        return true

    }
}
