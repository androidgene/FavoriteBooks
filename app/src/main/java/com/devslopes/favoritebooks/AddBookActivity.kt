package com.devslopes.favoritebooks


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devslopes.favoritebooks.databinding.AddBookBinding
import com.devslopes.favoritebooks.models.Book

class AddBookActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AddBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            BookRepository.addBook(enterItem(binding), this)
        }
    }

    fun enterItem(binding: AddBookBinding): Book {
        val newItem: String = "${binding.title.text.toString()}|${binding.author.text.toString()}|${binding.genre.text.toString()}| ${binding.length.text.toString()}"
        return Book.fromCsv(newItem)
    }
}