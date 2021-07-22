package com.example.bottomnavigationbar

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment = HomeFragment()
        val saveFragment =  SaveFragment()
        val profileFragment = ProfileFragment()
        setCurrentFragment(homeFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    setCurrentFragment(homeFragment)
                }
                R.id.save ->{
                    setCurrentFragment(saveFragment)
                }
                R.id.profile ->{
                    setCurrentFragment(profileFragment)
                }
            }
            true

        }
        bottomNavigationView.getOrCreateBadge(R.id.home).apply {
            number = 20
            isVisible = true

        }


    }
    private fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }
    }
}