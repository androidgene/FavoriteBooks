package com.devslopes.favoritebooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.devslopes.favoritebooks.databinding.ActivityMainBinding
import com.devslopes.favoritebooks.models.Book
import kotlinx.android.synthetic.main.add_book.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addFab.show()

        binding.bookList.apply {
            adapter = BooksAdapter(BookRepository.getBooks(this@MainActivity))
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.addFab.setOnClickListener {
            showAddScreen(binding)
        }
    }

    private fun showAddScreen(binding: ActivityMainBinding) {
        val intent = Intent(this, AddBookActivity::class.java)
        startActivity(intent)
    }
}
