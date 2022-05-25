package com.altaf.kisahnabiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.altaf.kisahnabiapp.data.KisahResponse
import com.altaf.kisahnabiapp.databinding.ActivityMainBinding
import com.altaf.kisahnabiapp.ui.MainViewModel
import com.altaf.kisahnabiapp.ui.detail.DetailActivity
import com.altaf.kisahnabiapp.ui.KisahAdapter
import com.altaf.kisahnabiapp.utils.OnItemClickCallback

class MainActivity : AppCompatActivity(), OnItemClickCallback {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var _viewModel : MainViewModel? = null
    private val viewModel get() = _viewModel as MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // ambil data dari viewModel
        viewModel.getData()

        viewModel.kisahResponse.observe(this){showData(it)}
        viewModel.isLoading.observe(this){showLoading(it)}
        viewModel.isError.observe(this){showError(it)}
    }

    private fun showData(data: List<KisahResponse>?) {
        binding.recyclerMain.apply {
            val mAdapter = KisahAdapter()
            mAdapter.setData(data)
            layoutManager = GridLayoutManager(this@MainActivity,2)
            adapter = mAdapter
            mAdapter.setOnItemClickCallback(object : OnItemClickCallback{
                override fun onItemClicked(item: KisahResponse) {
                    startActivity(Intent(applicationContext), DetailActivity::class.java)
                        .putExtra(DetailActivity.EXTRA_DATA, item)
                }
            })
        }
    }

    private fun showLoading(isLoading: Boolean?) {
        if (isLoading == true){
            binding.progressMain.visibility = View.VISIBLE
            binding.recyclerMain.visibility = View.INVISIBLE
        } else{
            binding.progressMain.visibility = View.IVISIBLE
            binding.recyclerMain.visibility = View.VISIBLE
        }

    }

    private fun showError(error: Throwable?) {
        Log.e("MainActivity", "showError: ${error?.message}")
    }

}