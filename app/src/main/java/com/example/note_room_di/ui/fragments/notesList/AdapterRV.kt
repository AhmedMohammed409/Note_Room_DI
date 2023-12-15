package com.example.note_room_di.ui.fragments.notesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.note_room_di.databinding.ItemBinding
import com.example.note_room_di.models.Note

class AdapterRV (private val onItemClicked: (note: Note) -> Unit) :
    ListAdapter<Note, AdapterRV.ViewHolder>(NotesDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position], onItemClicked)
    }

    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Note, onItemClicked: (note: Note) -> Unit) {
            binding.note = item
            binding.root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }
}

object NotesDiffUtil : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }
}