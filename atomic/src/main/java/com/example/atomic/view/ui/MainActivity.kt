package com.example.atomic.view.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.atomic.R
import com.example.atomic.adapter.SportAdapter
import com.example.atomic.model.Sport
import com.example.atomic.view.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var randomGenerator: Random? = null
    private var sports: MutableList<Sport>? = null
    private lateinit var sportList: RecyclerView

    // viewModels() delegate used to get
    // by view models will automatically construct the viewmodels using Hilt
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sportList = findViewById<RecyclerView>(R.id.sport_list)
        sportList.layoutManager = LinearLayoutManager(this)
        randomGenerator = Random
        sports = mutableListOf<Sport>()
        observeCryptoCurrency()
    }

    // Observing the live data
    private fun observeCryptoCurrency() {
        viewModel.cryptoCurrency.observe(this) {
           Log.d("Value",it.toString())
           refreshValue(it)
        }
    }

    fun refreshValue(list: List<Sport>)
    {
        var sAdapter = SportAdapter(sports!!)
        sAdapter.clearItems()
        val index: Int = randomGenerator!!.nextInt(list.size)
        val item: Sport = list.get(index)
        sports!!.add(item)
        sportList.adapter = SportAdapter(sports!!)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_refresh ->  observeCryptoCurrency()
            else -> {}
        }
        return true;
    }
}