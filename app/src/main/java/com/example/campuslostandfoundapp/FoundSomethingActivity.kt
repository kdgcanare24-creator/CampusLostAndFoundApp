package com.glitchguild.campuslostandfound

import LostFoundItem
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.glitchguild.campuslostandfound.databinding.ActivityFoundSomethingBinding

class FoundSomethingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoundSomethingBinding
    private var selectedImageUri: Uri? = null
    private val PICK_IMAGE = 102

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoundSomethingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use ACTION_OPEN_DOCUMENT for reliable URI access
        binding.btnUploadPhotoFound?.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE)
        }

        binding.btnSubmitFound?.setOnClickListener {
            val name = binding.etFoundItemName?.text.toString().trim()
            val description = binding.etFoundDescription?.text.toString().trim()

            if (name.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            ItemStorage.items.add(
                LostFoundItem(
                    type = "Found",
                    name = name,
                    description = description,
                    imageUri = selectedImageUri?.toString()
                )
            )

            Toast.makeText(this, "Found item submitted!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            val uri = data?.data
            if (uri != null) {
                try {
                    // Persist access to the selected image
                    contentResolver.takePersistableUriPermission(
                        uri,
                        Intent.FLAG_GRANT_READ_URI_PERMISSION
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                selectedImageUri = uri
                binding.ivPhotoPreview?.setImageURI(selectedImageUri)
            }
        }
    }
}
