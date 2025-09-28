package com.app.alldownloaderstatic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var circle1: View
    private lateinit var circle2: View
    private lateinit var circle3: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        circle1 = findViewById(R.id.circle1)
        circle2 = findViewById(R.id.circle2)
        circle3 = findViewById(R.id.circle3)

        val allApps = listOf(
            AppMenuItem(R.drawable.dailymotion, "FB Save"),
            AppMenuItem(R.drawable.dailymotion, "FB Watch"),
            AppMenuItem(R.drawable.dailymotion, "WhatsApp"),
            AppMenuItem(R.drawable.dailymotion, "TikTok"),
            AppMenuItem(R.drawable.dailymotion, "Twitter"),
            AppMenuItem(R.drawable.dailymotion, "IG Saver"),
            AppMenuItem(R.drawable.dailymotion, "Dailymotion"),
            AppMenuItem(R.drawable.dailymotion, "Likee"),
            AppMenuItem(R.drawable.dailymotion, "Pinterest"),
            AppMenuItem(R.drawable.dailymotion, "ShareChat"),
            AppMenuItem(R.drawable.dailymotion, "Reddit"),
            AppMenuItem(R.drawable.dailymotion, "IMDb"),
            AppMenuItem(R.drawable.dailymotion, "Moj"),
            AppMenuItem(R.drawable.dailymotion, "MX TakaTak"),
            AppMenuItem(R.drawable.dailymotion, "Chingari"),
            AppMenuItem(R.drawable.dailymotion, "Zili"),
            AppMenuItem(R.drawable.dailymotion, "Raposo"),
            AppMenuItem(R.drawable.dailymotion, "Vimeo"),
            AppMenuItem(R.drawable.dailymotion, "Snack Video"),
            AppMenuItem(R.drawable.dailymotion, "LinkedIn"),
            AppMenuItem(R.drawable.dailymotion, "TED"),
            AppMenuItem(R.drawable.dailymotion, "Fandom"),
            AppMenuItem(R.drawable.dailymotion, "Suggestion"),
            AppMenuItem(R.drawable.dailymotion, "9Gag")
        )

        val pages = allApps.chunked(8)
        viewPager.adapter = ViewPagerAdapter(this, pages)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicators(position)
            }
        })
    }

    private fun updateIndicators(position: Int) {
        circle1.setBackgroundResource(
            if (position == 0) R.drawable.intro_circle_select else R.drawable.intro_circle_unselect
        )
        circle2.setBackgroundResource(
            if (position == 1) R.drawable.intro_circle_select else R.drawable.intro_circle_unselect
        )
        circle3.setBackgroundResource(
            if (position == 2) R.drawable.intro_circle_select else R.drawable.intro_circle_unselect
        )
    }
}
