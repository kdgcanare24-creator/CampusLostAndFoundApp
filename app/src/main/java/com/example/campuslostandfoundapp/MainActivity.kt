package com.glitchguild.campuslostandfound

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.glitchguild.campuslostandfound.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // View Lost Items
        binding.btnViewLost.setOnClickListener {
            startActivity(Intent(this, LostItemsActivity::class.java))
        }

        // Report Lost Item
        binding.btnReportLost.setOnClickListener {
            startActivity(Intent(this, ReportLostActivity::class.java))
        }

        // Found Something
        binding.btnFoundSomething.setOnClickListener {
            startActivity(Intent(this, FoundSomethingActivity::class.java))
        }
    }
}
