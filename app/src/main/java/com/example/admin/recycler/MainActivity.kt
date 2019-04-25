package com.example.admin.recycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapterMovie: AdapterMovie
    val gson = GsonBuilder().create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data : String = FakeService.getMovieRaw()
        val result : ResultModel = gson.fromJson(data, ResultModel::class.java)
        val movie : ArrayList<MovieModel> = result.results!!
        rvMovie.layoutManager = LinearLayoutManager(this)
        adapterMovie = AdapterMovie(this, movie)
        rvMovie.adapter = adapterMovie
    }
}
