package uz.gita.quotesappretrofitmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import uz.gita.quotesappretrofitmvvm.adapter.MyAdapter
import uz.gita.quotesappretrofitmvvm.databinding.ActivityMainBinding
import uz.gita.quotesappretrofitmvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.recycler.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        viewModel.quotesData.observe(this) {
            adapter.setDataList(it)
            binding.recycler.adapter = adapter
        }

        viewModel.errorData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        binding.button.setOnClickListener {
            loadData()
        }
    }

    private fun loadData() {
        viewModel.getQuotes()
    }
}