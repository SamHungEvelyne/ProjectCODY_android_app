package com.example.projectcodymentorapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentRecyclerViewAdapter (var studentData: ArrayList<Student>)
    : RecyclerView.Adapter<StudentRecyclerViewAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // inflate means to convert code into visual components
        val viewItem = LayoutInflater.from(parent.context).inflate(
            R.layout.student_view,
            parent,
            false
        )
        return RecyclerViewHolder(viewItem)
    }

    // returns size of arrayList of students
    override fun getItemCount(): Int {
        return studentData.size
    }

    // lambda expression to trigger the method
    lateinit var clickLambda: (Student) -> Unit

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(studentData[position], clickLambda)

    }

    // A holder class for each item in the list
    class RecyclerViewHolder(val viewItem: View) : RecyclerView.ViewHolder(viewItem) {

        fun bind(student: Student, clickLambda: (Student) -> Unit) {
            viewItem.findViewById<TextView>(R.id.name_student).text = student.first_name
            viewItem.findViewById<TextView>(R.id.phone_text).text = student.parent_phone
            viewItem.findViewById<TextView>(R.id.email_student).text = student.parent_email
            viewItem.findViewById<TextView>(R.id.age_student).text = student.age_group
            viewItem.findViewById<TextView>(R.id.sessions_student).text = student.sessions

            var img = viewItem.findViewById<ImageView>(R.id.student_image)
            img.setImageResource(R.drawable.female)

            viewItem.setOnClickListener {
                clickLambda (student)
            }
        }
    }

}