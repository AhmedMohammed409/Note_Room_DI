package com.example.note_room_di.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.note_room_di.databinding.FragmentChangeElementBinding
import com.example.note_room_di.model.entity.Note
import com.example.note_room_di.time.DataTimeManger
import com.example.note_room_di.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChangeElementFragment : Fragment() {
    private lateinit var binding: FragmentChangeElementBinding

    //@Inject
    //lateinit var   viewModelNote: MainViewModel
//    private val  viewModelNote: MainViewModel by viewModels()
    private val args: ChangeElementFragmentArgs by navArgs()
    private val  viewModelNote: MainViewModel by lazy{
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangeElementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCancel.setOnClickListener {
            findNavController().navigate(ChangeElementFragmentDirections.actionChangeElementFragmentToShowNoteFragment())
        }

        binding.btnChange.setOnClickListener {
            val nameNote = binding.etNameNote.text.toString()
            val note = binding.etNoteAdd.text.toString()
            val time = DataTimeManger.CurrentDataTime()

            if (note.isNotEmpty()&&nameNote.isNotEmpty()){
                viewModelNote.addNote(Note(args.id, nameNote, note, time))
                findNavController().navigate(ChangeElementFragmentDirections.actionChangeElementFragmentToShowNoteFragment())
            }
            else{
                if (nameNote.isEmpty()){binding.TilNameNote.error="please enter Correct Name of Note" }
                else{ binding.TilNameNote.isErrorEnabled=false }

                if (note.isEmpty()){ binding.TilNote.error="please enter Note" }
                else{ binding.TilNote.isErrorEnabled=false }
            }

        }
    }

}