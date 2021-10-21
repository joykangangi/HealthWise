package com.example.healthwise.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.healthwise.databinding.ArticleItemPreviewBinding
import com.example.healthwise.models.Disease

class HealthAdapter: RecyclerView.Adapter<HealthAdapter.HealthViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemPreviewBinding.inflate(layoutInflater, parent, false)
        return HealthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HealthViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount() = differ.currentList.size


    inner class HealthViewHolder(private var binding: ArticleItemPreviewBinding):
        RecyclerView.ViewHolder(binding.root) {

            fun bind(currentArticle: Disease) {
                binding.apply {
                    name.text = currentArticle.name
                    date.text = currentArticle.data_updated_at
                    root.setOnClickListener {
                        onItemClickListener?.let {
                            it(currentArticle)
                        }
                    }
                }
            }
        }

    private val differCallBack = object : DiffUtil.ItemCallback<Disease>() {
        override fun areItemsTheSame(oldItem: Disease, newItem: Disease): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Disease, newItem: Disease): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack) //manages list

    private var onItemClickListener: ( (Disease) -> Unit )? = null
    fun setOnItemClickListener(listener: (Disease) -> Unit ) {
        onItemClickListener = listener

    }

    }