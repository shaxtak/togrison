package com.example.togrison

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.togrison.databinding.ActivityMainBinding
import java.util.Random
import java.util.Scanner

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var random: Random
    private var secretNumber: Int = 0
    private var attempts: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        random = Random()
        secretNumber = random.nextInt(100) + 1

        binding.guessButton.setOnClickListener {
            val guess = binding.guessEditText.text.toString().toIntOrNull()
            if (guess != null) {
                attempts++
                when {
                    guess < secretNumber -> binding.resultTextView.text = "Katta son kiriting."
                    guess > secretNumber -> binding.resultTextView.text = "Kichik son kiriting."
                    else -> {
                        binding.resultTextView.text = "Tabriklayman! To'g'ri javobni topdingiz."
                        binding.attemptsTextView.text = "Siz $attempts ta urinish bilan topdingiz."
                        binding.guessButton.isEnabled = false
                    }
                }
            }
        }
    }
}