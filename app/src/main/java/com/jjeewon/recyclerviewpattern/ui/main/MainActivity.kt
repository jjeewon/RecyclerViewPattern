package com.jjeewon.recyclerviewpattern.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpattern.R
import com.example.recyclerviewpattern.databinding.ActivityMainBinding
import com.jjeewon.recyclerviewpattern.ui.main.listadapter.UserListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        observeViewModel()
    }

    private fun initAdapter() {
        adapter = UserListAdapter(
            onClick = {
                Toast.makeText(this@MainActivity, it.toString(),
                    Toast.LENGTH_LONG).show()
            }
        )
        binding.userList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.userList.adapter = adapter
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.users.collectLatest {
                    adapter.submitList(it)
                }
            }
        }
    }
}