package com.glitchguild.campuslostandfound

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.glitchguild.campuslostandfound.databinding.ActivityFoundSomethingBinding

class FoundSomethingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoundSomethingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoundSomethingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Upload Photo and Submit Found Item functionality can be added here
    }
}
