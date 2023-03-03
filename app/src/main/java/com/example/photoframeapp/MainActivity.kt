package com.example.photoframeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    // First we will make an integer variable which will tell us which image is being seen
    var currentImage = 0 // We make val when we want our variable to never change in the project
    lateinit var image: ImageView
    var names = arrayOf("Rowan Atkinson", "Leonardo Di Caprio", "Albert Einstein", "Virat Kohli")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val prev = findViewById<ImageButton>(R.id.imgPrev)
        val next = findViewById<ImageButton>(R.id.imgNext)
        val text = findViewById<TextView>(R.id.textView)

        prev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage - 1) % 4 //For Going to prev image..
            val idImageToShowString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            text.text = names[currentImage]
        }

        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage + 1) % 4
            val idImageToShowString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            text.text = names[currentImage]

        }
    }
}