package com.devslopes.favoritebooks

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.devslopes.favoritebooks.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
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

            val mIth = ItemTouchHelper(
                object : ItemTouchHelper.SimpleCallback(
                    0,
                    ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
                ) {
                    override fun onMove(
                        recyclerView: RecyclerView,
                        viewHolder: ViewHolder, target: ViewHolder
                    ): Boolean {
                        return false // Move is not used
                    }

                    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                        val position = viewHolder.adapterPosition
                        val bookRepositoryList = BookRepository.getBooks(context)
                        BookRepository.removeBook(bookRepositoryList[position], this@MainActivity)
                        adapter!!.notifyItemRemoved(position)
                    }
                }
            )
            mIth.attachToRecyclerView(this)
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
