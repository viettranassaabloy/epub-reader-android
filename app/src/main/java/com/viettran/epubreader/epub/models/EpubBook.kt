package com.viettran.epubreader.epub.models

data class EpubBook(
    val fileName: String,
    val title: String,
    val author: String,
    val language: String,
    val coverImage: ByteArray?,
    val chapters: List<EpubChapter>,
    val images: List<EpubImage>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EpubBook
        if (fileName != other.fileName) return false
        if (title != other.title) return false
        if (author != other.author) return false
        if (language != other.language) return false
        if (coverImage != null) {
            if (other.coverImage == null) return false
            if (!coverImage.contentEquals(other.coverImage)) return false
        } else if (other.coverImage != null) return false
        if (chapters != other.chapters) return false
        if (images != other.images) return false
        return true
    }

    override fun hashCode(): Int {
        var result = fileName.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + language.hashCode()
        result = 31 * result + (coverImage?.contentHashCode() ?: 0)
        result = 31 * result + chapters.hashCode()
        result = 31 * result + images.hashCode()
        return result
    }
}