package com.jeygm.platziconf.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.jeygm.platziconf.R
import com.jeygm.platziconf.model.Speaker
import kotlinx.android.synthetic.main.fragment_speakers_detail_dialog.*


class SpeakersDetailDialogFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FulScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speakers_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tbSpeakers.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        tbSpeakers.setTitleTextColor(Color.WHITE)
        tbSpeakers.setNavigationOnClickListener { dismiss() }

        val speaker = arguments?.getSerializable("speaker") as Speaker
        Glide.with(imageSpeaker.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(imageSpeaker)
        tbSpeakers.title = tbSpeakers.title
        tvDetailSpeakerName.text = speaker.name
        tvDetailSpeakerJobTitle.text = speaker.jobTitle
        tvDetailSpeakerWork.text = speaker.workplace
        ivSpeakerTwitter.setOnClickListener{
            val url = speaker.twitter
            val uri = Uri.parse("https://twitter.com/"+url)
            val launchBrowser = Intent(Intent.ACTION_VIEW, uri)
            startActivity(launchBrowser)
        }
        tvDetailSpeakerDescription.text = speaker.biography
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}