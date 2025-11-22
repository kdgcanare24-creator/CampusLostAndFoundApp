package com.glitchguild.campuslostandfound

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.glitchguild.campuslostandfound.databinding.ActivityLostItemsBinding

class LostItemsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLostItemsBinding
    private lateinit var adapter: LostFoundAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLostItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = LostFoundAdapter(ItemStorage.items)

        binding.rvItems.layoutManager = LinearLayoutManager(this)
        binding.rvItems.adapter = adapter

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}
