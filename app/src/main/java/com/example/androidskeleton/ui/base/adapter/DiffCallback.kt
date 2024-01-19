package com.example.androidskeleton.ui.base.adapter

import androidx.recyclerview.widget.DiffUtil
object DiffCallback : DiffUtil.ItemCallback<AdapterData>() {
    override fun areItemsTheSame(oldItem: AdapterData, newItem: AdapterData) =
        oldItem.comparable == newItem.comparable

    override fun areContentsTheSame(oldItem: AdapterData, newItem: AdapterData) =
        oldItem.isContentTheSame(newItem)
}
