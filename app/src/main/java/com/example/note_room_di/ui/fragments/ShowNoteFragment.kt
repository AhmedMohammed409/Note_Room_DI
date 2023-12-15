package com.example.note_room_di.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.note_room_di.OnListItemClick
import com.example.note_room_di.databinding.FragmentShowNoteBinding
import com.example.note_room_di.model.entity.Note
import com.example.note_room_di.ui.AdapterRV
import com.example.note_room_di.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ShowNoteFragment  : Fragment(),OnListItemClick {
    private lateinit var binding: FragmentShowNoteBinding

    //@Inject
    //lateinit var   viewModelNote: MainViewModel
//     private val  viewModelNote: MainViewModel by viewModels()
    private val  viewModelNote: MainViewModel by lazy{
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private  val adapterRv: AdapterRV by  lazy { AdapterRV() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.visibility = View.VISIBLE
        viewModelNote.notesLiveData.observe(viewLifecycleOwner) {
            adapterRv.setList(it.toMutableList())
            binding.RV.adapter = adapterRv
            binding.progressBar.visibility = View.GONE
        }
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(ShowNoteFragmentDirections.actionShowNoteFragmentToAddElementFragment())
        }
    }

    override fun onItemclick(note: Note) {
        Toast.makeText(context,note.nameNote,Toast.LENGTH_LONG).show()
    }
}


