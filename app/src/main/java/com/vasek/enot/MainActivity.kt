package com.vasek.enot

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEdit: EditText = findViewById(R.id.nameEditText)
        val moodEdit: EditText = findViewById(R.id.moodEditText)
        val greetBtn: ImageButton = findViewById(R.id.greetButton)
        val resultText: TextView = findViewById(R.id.resultTextView)
        val moodImage: ImageView = findViewById(R.id.moodImageView)

        greetBtn.setOnClickListener {
            val name = nameEdit.text.toString().trim()
            val mood = moodEdit.text.toString().trim().lowercase()

            // Приветствие
            val hello = if (name.isEmpty()) {
                getString(R.string.hello_anon)
            } else {
                getString(R.string.hello_named, name)
            }

            // Реакция на настроение
            when {
                mood.contains("хорош") || mood.contains("отлич") ||
                        mood.contains("радост") || mood.contains("счаст") -> {
                    resultText.text = "$hello ${getString(R.string.mood_good)}"
                    moodImage.setImageResource(android.R.drawable.ic_menu_compass)
                }
                mood.contains("плох") || mood.contains("груст") ||
                        mood.contains("устал") || mood.contains("печаль") -> {
                    resultText.text = "$hello ${getString(R.string.mood_bad)}"
                    moodImage.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                }
                mood.contains("норм") || mood.contains("средн") ||
                        mood.contains("так себе") -> {
                    resultText.text = "$hello ${getString(R.string.mood_neutral)}"
                    moodImage.setImageResource(android.R.drawable.ic_menu_info_details)
                }
                mood.isEmpty() -> {
                    resultText.text = "$hello ${getString(R.string.mood_unknown)}"
                    moodImage.setImageResource(android.R.drawable.ic_menu_help)
                }
                else -> {
                    resultText.text = "$hello ${getString(R.string.mood_unknown)}"
                    moodImage.setImageResource(android.R.drawable.ic_menu_help)
                }
            }

            // Анимация появления результата
            greetBtn.alpha = 0f
            greetBtn.scaleX = 0.5f
            greetBtn.scaleY = 0.5f
            greetBtn.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(400)
                .start()
        }
    }
}