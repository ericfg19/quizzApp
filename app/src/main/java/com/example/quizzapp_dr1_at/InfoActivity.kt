package com.example.quizzapp_dr1_at

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.ListFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        findViewById<ViewPager2>(R.id.frag1).adapter = ScreenSlidePagerAdapter(this)




        val btnlogo = findViewById<ImageButton>(R.id.btnLogo)
        btnlogo.setOnClickListener {
            val intentImplicita = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.infnet.edu.br/"))
                    startActivity(intentImplicita)
        }

        val btnlogo2 = findViewById<ImageButton>(R.id.btnLogoLand)
        btnlogo.setOnClickListener {
            val intentImplicita2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.infnet.edu.br/"))
            startActivity(intentImplicita2)
        }

        val btnVoltar = findViewById<Button>(R.id.btnvoltar)
        btnVoltar.setOnClickListener {
            val Lista = Intent(this, MainActivity::class.java)
            startActivity(Lista)
        }


    }

    class ScreenSlidePagerAdapter (fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 1

        override fun createFragment(position: Int): Fragment = MyFragment()


    }
    class ScreenSlidePagerAdapter2 (fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 1

        override fun createFragment(position: Int): Fragment = MyFragment2()


    }
}