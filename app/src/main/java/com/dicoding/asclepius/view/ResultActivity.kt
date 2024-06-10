package com.dicoding.asclepius.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra(EXTRA_RESULT)
        binding.resultText.text = result

        val imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE))
        imageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.resultImage.setImageURI(it)
        }
    }

    companion object {
        const val EXTRA_IMAGE = "extra_image_uri"
        const val EXTRA_RESULT = "extra_result"
    }
}