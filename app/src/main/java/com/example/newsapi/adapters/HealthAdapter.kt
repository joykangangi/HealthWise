package com.example.newsapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.models.HealthResponse
import com.example.newsapi.models.Result

class HealthAdapter: RecyclerView.Adapter<HealthAdapter.HealthViewHolder>() {

    inner class HealthViewHolder(private var binding:)

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
        val binding =
    }

    override fun onBindViewHolder(holder: HealthViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}