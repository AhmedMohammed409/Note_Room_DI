package com.example.note_room_di.ui.fragments.addNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.note_room_di.databinding.FragmentAddElementBinding
import com.example.note_room_di.models.Note
import com.example.note_room_di.utils.currentDateTime
import com.example.note_room_di.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddElementFragment : Fragment() {

    private lateinit var binding: FragmentAddElementBinding
    private val viewModelNote: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddElementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val nameNote = binding.etNameNote.text.toString()
            val note = binding.etNoteAdd.text.toString()
            val time = currentDateTime()

            if (note.isNotEmpty() && nameNote.isNotEmpty()) {
                viewModelNote.addNote(Note(nameNote, note, time))
                findNavController().navigateUp()
            } else {
                if (nameNote.isEmpty()) {
                    binding.TilNameNote.error = "please enter Correct Name of Note"
                } else {
                    binding.TilNameNote.isErrorEnabled = false
                }

                if (note.isEmpty()) {
                    binding.TilNote.error = "please enter Note"
                } else {
                    binding.TilNote.isErrorEnabled = false
                }

                Toast.makeText(context, "Please Check Note", Toast.LENGTH_SHORT).show()
            }
        }
    }
}