package com.devslopes.favoritebooks


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devslopes.favoritebooks.databinding.AddBookBinding

class AddBookActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AddBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {

        }
    }
}