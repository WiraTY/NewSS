package com.example.schooter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*
import com.example.schooter.databinding.ItemPostBinding

//class PostAdapter (private val list: ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
//    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        fun bind(postResponse: PostResponse){
//            with(itemView){
//                val text = "author: ${postResponse.author}\n" +
//                        "title: ${postResponse.title}\n"
//                tvText.text = text
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
//        return PostViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//        holder.bind(list[position])
//    }
//
//    override fun getItemCount(): Int = list.size
//}

class PostAdapter (private val list: ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.NewsViewHolder>(){

    inner class NewsViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NewsViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.tvText.text = this.title
                binding.author.text = this.author
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}