package com.example.scentsynth

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nameText = findViewById<TextView>(R.id.perfumeName)
        val notesText = findViewById<TextView>(R.id.perfumeNotes)
        val descriptionText = findViewById<TextView>(R.id.perfumeDescription)
        val perfumeImage = findViewById<ImageView>(R.id.perfumeImage)

        val note1 = intent.getStringExtra("NOTE1") ?: "Unknown"
        val note2 = intent.getStringExtra("NOTE2") ?: "Unknown"

        val perfume = generatePerfume(note1, note2)

        nameText.text = perfume.name
        notesText.text = "Dominant Notes: ${perfume.notes.joinToString(", ")}"
        descriptionText.text = perfume.description

        // Example logic to display an image; default image used here
        perfumeImage.setImageResource(R.drawable.`perfume_placeholder`)
    }

    private fun generatePerfume(note1: String, note2: String): Perfume {
        val name = "${note1.replaceFirstChar { it.uppercase() }} & ${note2.replaceFirstChar { it.uppercase() }}"
        val description = "A luxurious fusion of $note1 and $note2. This scent awakens the senses with contrast and harmony, ideal for moments of mystery and allure."
        return Perfume(name, listOf(note1, note2), description)
    }
}