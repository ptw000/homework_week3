package com.example.admin.recycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_screen.*
class DetailScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)
        val movieModel : MovieModel =intent.extras.get("data") as MovieModel
        val imgUrl : String = Constant.getUrl() + movieModel.poster_path
        val title : String? = movieModel.title
        val release_date : String? = movieModel.release_date
        val overview : String? = movieModel.overview
        val star : Float? = movieModel.vote_average
        txtTitle.text = title
        txtReleaseDate.text = "Release date: ".plus(release_date)
        txtOverView.text = overview
        ratingBar.rating = (star?.div(2))!!
        Glide.with(this@DetailScreen)
                .load(imgUrl)
                .into(imgAvatar)
    }
}
