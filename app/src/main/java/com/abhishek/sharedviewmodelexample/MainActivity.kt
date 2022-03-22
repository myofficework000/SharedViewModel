package com.abhishek.sharedviewmodelexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.abhishek.sharedviewmodelexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var webFragment: WebViewFragment
    private lateinit var bookmarksFragment: BookmarksFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        webFragment = WebViewFragment()
        bookmarksFragment = BookmarksFragment()

        supportFragmentManager.beginTransaction().add(R.id.container1, webFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.container2, bookmarksFragment).commit()

        viewModel.selectedUrl.observe(this) {

        }
    }
}