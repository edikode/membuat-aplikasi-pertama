package com.codeosing.projectsubmissondestinasiwisata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvFestival: RecyclerView
    private var list: ArrayList<Festival> = arrayListOf()

    private var title: String = "Festival Banyuwangi"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        setActionBarTitle(title)

        val iv_profile : ImageView = findViewById(R.id.iv_btnprofile)
        iv_profile.setOnClickListener(this)

        rvFestival = findViewById(R.id.rv_festival)
        rvFestival.setHasFixedSize(true)

        list.addAll(FestivalData.listData)
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecyclerList() {
        rvFestival.layoutManager = LinearLayoutManager(this)
        val festivalAdapter = FestivalAdapter(list)
        rvFestival.adapter = festivalAdapter

        festivalAdapter.setOnItemClickCallback(object : FestivalAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Festival) {
                showSelectedFestival(data)
            }
        })
    }

    private fun showSelectedFestival(festival: Festival) {
        Log.e("error", festival.photo.toString())

        val detailIntent = Intent(this@MainActivity, DetailFestivalActivity::class.java)
        detailIntent.putExtra(DetailFestivalActivity.EXTRA_NAME, festival.name)
        detailIntent.putExtra(DetailFestivalActivity.EXTRA_LOCATION, festival.location)
        detailIntent.putExtra(DetailFestivalActivity.EXTRA_IMAGE, festival.photo.toString())
        startActivity(detailIntent)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.iv_btnprofile -> {
                val detailFestivalIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(detailFestivalIntent)
            }
        }
    }
}