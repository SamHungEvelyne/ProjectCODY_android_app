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
        firebaseDatabase.value?.addValueEventListener(this)
    }

    /**
     * get all students
     */
    fun getStudents(): ArrayList<Student> {
        val students = ArrayList<Student>()
        entryList.value?.forEach {
            if (it is Student) {
                students.add(it)
            }
        }
        return students
    }

    fun getCourses(): ArrayList<Course> {
        val courses = ArrayList<Course>()
        entryList.value?.forEach {
            if (it is Course) {
                courses.add(it)
            }
        }
        return courses
    }


    fun setCurrentEntry(entry: Entry) {
        currentEntry.postValue(entry);
    }

    fun addOrUpdateEntry(entry: Entry) {
        var id = "id"
        var pathName = "type"
        if (entry is Student) {
            id = entry.email.replace(".", "")
            pathName = "Students"
        }
        else if (entry is Mentor) {
            id = entry.email.replace(".", "")
            pathName = "Mentors"
        }
        else if (entry is Course) {
            id = entry.name.replace(" ", "_")
            pathName = "Courses"
        }

        firebaseDatabase.value?.child(pathName)?.child(id)?.setValue(entry)

    }

    override fun onDataChange(snapshot: DataSnapshot) {
        // Get everything in the database and postValue
        val entries = ArrayList<Entry>()
        snapshot.child("Students").children.forEach {
            it.getValue(Student::class.java)?.let {
                entries.add(it)
            }
        }
        snapshot.child("Courses").children.forEach {
            it.getValue(Course::class.java)?.let {
                entries.add(it)
            }
        }
        snapshot.child("Mentors").children.forEach {
            it.getValue(Mentor::class.java)?.let {
                entries.add(it)
            }
        }
        entryList.postValue(entries)
    }

    override fun onCancelled(error: DatabaseError) {
        // Nothing LOL
    }


}