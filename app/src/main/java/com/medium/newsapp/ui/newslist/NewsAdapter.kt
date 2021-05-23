package com.medium.newsapp.ui.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.medium.newsapp.databinding.ItemArticleBinding
import com.medium.newsapp.model.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val articleList: MutableList<Article> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    override fun getItemCount(): Int = articleList.size

    fun setArticles(list: MutableList<Article>) {
        articleList.clear()
        articleList.addAll(list)
    }

    class ViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.apply {
                item = article
            }
        }
    }


}