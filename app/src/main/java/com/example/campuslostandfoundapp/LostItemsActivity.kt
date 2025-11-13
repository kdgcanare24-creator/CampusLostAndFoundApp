package com.glitchguild.campuslostandfound

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.glitchguild.campuslostandfound.databinding.ActivityLostItemsBinding

class LostItemsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLostItemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLostItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
