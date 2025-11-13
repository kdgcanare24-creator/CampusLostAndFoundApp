package com.glitchguild.campuslostandfound

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.glitchguild.campuslostandfound.databinding.ActivityReportLostBinding

class ReportLostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReportLostBinding
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportLostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Upload photo
        binding.btnUploadPhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, 100)
        }

        // Submit report
        binding.btnSubmitReport.setOnClickListener {
            val itemName = binding.etItemName.text.toString().trim()
            val description = binding.etDescription.text.toString().trim()

            if (itemName.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Lost item reported successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    // Handle selected photo
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            selectedImageUri = data?.data
            Toast.makeText(this, "Photo selected!", Toast.LENGTH_SHORT).show()
        }
    }
}
