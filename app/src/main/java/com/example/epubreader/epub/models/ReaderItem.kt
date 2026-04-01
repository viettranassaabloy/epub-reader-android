/**
 * Inspired by Pool-Of-Tears/Myne (Apache License 2.0)
 * https://github.com/Pool-Of-Tears/Myne
 */

package com.example.epubreader.epub.models

sealed class ReaderItem {
    data class Text(val spans: List<HtmlSpan>) : ReaderItem()
    data class Image(val path: String, val yrel: Float = 0f) : ReaderItem()
    data class CodeBlock(val code: String) : ReaderItem()
    data class Blockquote(val spans: List<HtmlSpan>) : ReaderItem()
}

sealed class HtmlSpan {
    data class Text(val text: String) : HtmlSpan()
    data class Tag(
        val name: String,
        val attributes: Map<String, String>,
        val children: List<HtmlSpan>
    ) : HtmlSpan()
}