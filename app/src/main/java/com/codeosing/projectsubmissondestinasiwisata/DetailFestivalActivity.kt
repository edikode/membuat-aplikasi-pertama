 package com.codeosing.projectsubmissondestinasiwisata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide

 class DetailFestivalActivity : AppCompatActivity() {

    private var title: String = "Detail Festival"

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_LOCATION = "extra_location"
        const val EXTRA_IMAGE = "extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_festival)

        initView()
    }

    private fun initView() {
        setActionBarTitle(title)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val image = intent.getStringExtra(EXTRA_IMAGE)
        var imageResult : Int = Integer.parseInt(image.toString())

        val iv_festival : ImageView = findViewById(R.id.iv_festival)
        Glide.with(applicationContext)
                .load(imageResult)
                .centerCrop()
                .into(iv_festival)

        Toast.makeText(this, "kamu pilih " + image, Toast.LENGTH_SHORT).show()
    }

    private fun setActionBarTitle(title: String) {
        val toolbarTitle: TextView = findViewById(R.id.tv_toolbar)
        toolbarTitle.text = title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}