package com.example.projectcodymentorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    val viewModel: EntryViewModel by viewModels<EntryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)

        val burgerVector = findViewById<ImageView>(R.id.burger_vector)
        burgerVector.setOnClickListener(View.OnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        )

        val navView: NavigationView = findViewById(R.id.left_slide_menu)
        val navController = findNavController(R.id.nav_host_frag)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.menuHome, R.id.menuClasses, R.id.menuStudents)
            , drawerLayout
        )


//        setupActionBarWithNavController(navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
//        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)
//        NavigationUI.setupWithNavController(R.id.toolbar, navController, appBarConfiguration)

    }
}