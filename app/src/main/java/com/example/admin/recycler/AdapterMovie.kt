package com.example.admin.recycler

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie.view.*
import java.io.Serializable

class AdapterMovie(val context : Context, val item : ArrayList<MovieModel>) : RecyclerView.Adapter<ViewHolderMovie>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolderMovie {
        return ViewHolderMovie(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return item.size;
    }

    override fun onBindViewHolder(holder: ViewHolderMovie, i: Int) {
        Glide.with(context)
                .load(Constant.getUrl() + item[i].poster_path)
                .into(holder.imgAvatar)
        holder.txtName.text = item[i].title
        holder.txtDescription.text = item[i].overview
        if(item[i].video!!) {
            holder.imgPlay.setVisibility(View.VISIBLE)
        }
        holder.setListenerEventClick(listenerEventClick)
    }
    private val listenerEventClick = object : IListenerEventClick {
        override fun itemClick(position: Int) {
           val intent = Intent(context, DetailScreen::class.java)
            val movieModel : MovieModel  = item[position]
            intent.putExtra("data", movieModel as Serializable)
            context.startActivity(intent)
        }
    }
}

class ViewHolderMovie(itemView: View) : RecyclerView.ViewHolder(itemView){
    var iListenerEventClick : IListenerEventClick? = null
    var imgAvatar = itemView.imgAvatar
    var imgPlay = itemView.imgPlay
    var txtName = itemView.txtName
    var txtDescription = itemView.txtDesctiption
    fun setListenerEventClick(iListenerEventClick : IListenerEventClick) {
        this.iListenerEventClick = iListenerEventClick
    }
    init {
        itemView.setOnClickListener {
            iListenerEventClick?.itemClick(adapterPosition)
        }
    }
}
