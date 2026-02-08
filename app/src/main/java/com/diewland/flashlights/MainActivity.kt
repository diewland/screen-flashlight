package com.diewland.flashlights

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.diewland.flashlights.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_MOVE || event.action == MotionEvent.ACTION_DOWN) {
                // update layout black height
                val blackLayoutParams = binding.llBlack.layoutParams as LinearLayout.LayoutParams
                blackLayoutParams.weight = event.y
                binding.llBlack.layoutParams = blackLayoutParams

                // update layout white height
                val whiteLayoutParams = binding.llWhite.layoutParams as LinearLayout.LayoutParams
                whiteLayoutParams.weight = binding.root.height - event.y
                binding.llWhite.layoutParams = whiteLayoutParams
            }
            true
        }
    }

}