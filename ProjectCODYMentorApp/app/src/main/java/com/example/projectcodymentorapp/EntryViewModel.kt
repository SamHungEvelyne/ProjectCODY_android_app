package com.example.projectcodymentorapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class EntryViewModel : ViewModel(), ValueEventListener {
    var entryList = MutableLiveData<ArrayList<Entry>>()
    var currentEntry = MutableLiveData<Entry>()

    var firebaseDatabase = MutableLiveData<DatabaseReference>()

    init {
        entryList.value = ArrayList()
        firebaseDatabase.value = Firebase.database.getReference("")
    }

    /**
     * get all students
     */
    fun getStudents() {

    }

    fun setCurrentEntry(entry: Entry) {

    }

    override fun onDataChange(snapshot: DataSnapshot) {
        // Get everything in the database and postValue
        val entries = ArrayList<Entry>()
        snapshot.children
    }

    override fun onCancelled(error: DatabaseError) {
        // Nothing LOL
    }


}