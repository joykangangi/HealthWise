package com.example.newsapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.databinding.ArticleItemPreviewBinding
import com.example.newsapi.models.Disease
import com.example.newsapi.models.HealthResponse
import com.example.newsapi.models.Result

class HealthAdapter: RecyclerView.Adapter<HealthAdapter.HealthViewHolder>() {

    inner class HealthViewHolder(private var binding: ArticleItemPreviewBinding):
        RecyclerView.ViewHolder(binding.root) {

            fun bind(currentArticle: Disease) {binding.apply {

            }

            }
        }

    private val differCallBack = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemPreviewBinding.inflate(layoutInflater, parent, false)
        return HealthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HealthViewHolder, position: Int) {
val article = differ.currentList[position]
        holder.bind()
    }

    override fun getItemCount(): Int {
        val currentArticle = differ.currentList.size
    }

}