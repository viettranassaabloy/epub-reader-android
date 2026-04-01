package com.example.epubreader

import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.folioreader.Config
import com.folioreader.FolioReader
import com.example.epubreader.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedEpubUri: Uri? = null
    private var copiedFilePath: String? = null

    private val filePickerLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                selectedEpubUri = it
                val fileName = getFileName(it)
                binding.tvSelectedFile.text = "📄 $fileName"
                binding.btnReadFile.isEnabled = true
                copiedFilePath = copyEpubToInternal(it)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPickFile.setOnClickListener {
            filePickerLauncher.launch("application/epub+zip")
        }

        binding.btnReadFile.setOnClickListener {
            copiedFilePath?.let { path ->
                openEpubWithFolioReader(path)
            } ?: Toast.makeText(this, "Vui lòng chọn file trước!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getFileName(uri: Uri): String {
        var name = "unknown.epub"
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (nameIndex >= 0) name = it.getString(nameIndex)
            }
        }
        return name
    }

    private fun copyEpubToInternal(uri: Uri): String? {
        return try {
            val fileName = getFileName(uri)
            val outputFile = File(filesDir, fileName)
            val inputStream: InputStream? = contentResolver.openInputStream(uri)
            val outputStream = FileOutputStream(outputFile)
            inputStream?.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }
            outputFile.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Lỗi khi copy file: ${'$'}{e.message}", Toast.LENGTH_SHORT).show()
            null
        }
    }

    private fun openEpubWithFolioReader(filePath: String) {
        val config = Config().apply {
            isShowTts = true
            isNightMode = false
            font = Config.FONT_ANDADA
            fontSize = 2
            isShowRemainingIndicator = true
        }
        FolioReader.get()
            .setConfig(config, true)
            .openBook(filePath)
    }

    override fun onDestroy() {
        FolioReader.clear()
        super.onDestroy()
    }
}