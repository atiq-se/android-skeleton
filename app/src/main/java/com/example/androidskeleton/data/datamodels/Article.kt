package com.example.androidskeleton.data.datamodels

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String,
    val price: Float,
    val imageURI: String
) : Parcelable {
    constructor() : this(id = 1, title = "", description = "", price = 0.0f, imageURI = "")
}
