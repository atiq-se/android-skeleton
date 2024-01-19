package com.example.androidskeleton.ui.base.adapter

interface AdapterData {
    val comparable: Any
    fun isContentTheSame(data: AdapterData) = this == data
}