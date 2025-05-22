package com.example.scentsynth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNote1 = findViewById<EditText>(R.id.inputNote1)
        val inputNote2 = findViewById<EditText>(R.id.inputNote2)
        val generateButton = findViewById<Button>(R.id.generateButton)

        generateButton.setOnClickListener {
            val note1 = inputNote1.text.toString().trim()
            val note2 = inputNote2.text.toString().trim()

            if (note1.isNotEmpty() && note2.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("NOTE1", note1)
                    putExtra("NOTE2", note2)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter two fragrance notes", Toast.LENGTH_SHORT).show()
            }
        }
    }
}