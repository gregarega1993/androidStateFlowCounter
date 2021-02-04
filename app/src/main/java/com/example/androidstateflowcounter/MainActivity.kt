package com.example.androidstateflowcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenStarted {
            viewModel.countState.collect {
                tvCount.text = "$it"
            }
        }

        bIncrement.setOnClickListener {
            viewModel.incrementCount()
        }

        bDecrement.setOnClickListener {
            viewModel.decrementCount()
        }

    }

}