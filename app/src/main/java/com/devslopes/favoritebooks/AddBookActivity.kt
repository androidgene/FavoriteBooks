package com.devslopes.favoritebooks


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devslopes.favoritebooks.databinding.AddBookBinding
import com.devslopes.favoritebooks.models.Book
import kotlinx.android.synthetic.main.activity_main.*

class AddBookActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AddBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val newBook = enterItem(binding)
            BookRepository.addBook(newBook, this)
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun enterItem(binding: AddBookBinding): Book {
        val newItem = "${binding.title.text},${binding.author.text},${binding.genre.text},${binding.length.text}"
        return Book.fromCsv(newItem)

    }
}