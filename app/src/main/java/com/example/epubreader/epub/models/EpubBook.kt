package com.example.epubreader.epub.models

import android.graphics.Bitmap

data class EpubBook(
    val fileName: String,
    val title: String,
    val author: String,
    val language: String,
    val coverImage: Bitmap?,
    val chapters: List<EpubChapter>,
    val filePath: String
)