package com.example.projectcodymentorapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EntryRecyclerViewAdapter(var entryList: ArrayList<Entry>, var clickLambda: (Entry) -> Unit) :
    RecyclerView.Adapter<EntryRecyclerViewAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.student_view, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return entryList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(entryList[position])
    }

    class RecyclerViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(entry: Entry) {
            // different compositions for different tags

        }
    }
}