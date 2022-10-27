package com.csibtn.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csibtn.criminalintent.databinding.ActivityMainBinding

private lateinit var mainBinding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }
}