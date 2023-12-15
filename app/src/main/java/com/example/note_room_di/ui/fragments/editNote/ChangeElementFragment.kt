package com.example.note_room_di.ui.fragments.editNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.note_room_di.databinding.FragmentChangeElementBinding
import com.example.note_room_di.models.Note
import com.example.note_room_di.ui.MainViewModel
import com.example.note_room_di.utils.currentDateTime
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChangeElementFragment : Fragment() {

    private lateinit var binding: FragmentChangeElementBinding
    private val viewModelNote: MainViewModel by viewModels()
    private val args: ChangeElementFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangeElementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etNameNote.setText(args.nameNote)
        binding.etNoteAdd.setText(args.note)

        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnChange.setOnClickListener {
            val nameNote = binding.etNameNote.text.toString()
            val note = binding.etNoteAdd.text.toString()
            val time = currentDateTime()

            if (note.isNotEmpty() && nameNote.isNotEmpty()) {
                viewModelNote.addNote(Note(nameNote, note, time, args.id))
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
            }

        }
    }

}