package com.example.projectcodymentorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    val viewModel: EntryViewModel by viewModels<EntryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set Firebase manually
//        val options = FirebaseOptions.Builder()
//            .setApplicationId("com.example.messageapp")
//            .setApiKey("AIzaSyDZ6RTPu-3UtbzbvLefDrwlLileBRz1rpc")
//            .setDatabaseUrl("https://messageapptest-329bb.firebaseio.com")
//            .build()
//        val app = FirebaseApp.initializeApp(application, options, "messageapptest-329bb")
//
//        viewModel.firebaseDatabase.value = FirebaseDatabase.getInstance(app).reference // set
    }
}