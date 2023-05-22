package com.example.testovoe11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class LessonAdapter (val lessons: List<Lesson>) : RecyclerView.Adapter<LessonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lesson_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lesson = lessons[position]
        holder.textViewName.text = lesson.name
        holder.textViewTema.text = lesson.tema
        holder.textViewText.text = lesson.text
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewTema: TextView = itemView.findViewById(R.id.textViewTema)
        val textViewText: TextView = itemView.findViewById(R.id.textViewText)
    }
}