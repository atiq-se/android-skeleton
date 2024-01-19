package com.example.androidskeleton.ui.info.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidskeleton.data.datamodels.Article
import com.example.androidskeleton.databinding.ItemArticlesBinding

class ArticlesAdapter(
    private val mArticleClickListener: ArticleItemClickListener,
    private val articles: List<Article>
) : RecyclerView.Adapter<ArticlesAdapter.ArticleListViewHolder>() {

    inner class ArticleListViewHolder(val binding: ItemArticlesBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ArticleItemClickListener(val articleClickListener: (data: Article) -> Unit) {
        fun onClick(data: Article) = articleClickListener(data)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ArticleListViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemArticlesBinding.inflate(layoutInflater, viewGroup, false)
        return ArticleListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleListViewHolder, position: Int) {
        val article = articles.get(holder.absoluteAdapterPosition)
        with(holder) {
            binding.tvTitle.text = article.title
            binding.tvBody.text = article.description
            binding.tvPrice.text = article.price.toString()
            Glide.with(binding.tvTitle.context)
                .load(article.imageURI)
                .centerCrop()
                .into(binding.articleImage)

        }
    }

}


