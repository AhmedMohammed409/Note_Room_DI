package com.example.note_room_di.ui.fragments.notesList

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.note_room_di.databinding.FragmentShowNoteBinding
import com.example.note_room_di.models.Note
import com.example.note_room_di.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowNoteFragment : Fragment() {

    private lateinit var binding: FragmentShowNoteBinding
    private val viewModelNote: MainViewModel by viewModels()

    private  val  adapterRv:AdapterRV by lazy {
          AdapterRV(onItemClicked = {note ->
              showDialog(note)
              Toast.makeText(requireContext(),"clicked in ${note.nameNote}",Toast.LENGTH_SHORT).show()
        })
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
        binding.RV.adapter = adapterRv

        viewModelNote.list.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = false

            if (it.isNullOrEmpty()) {
                binding.RV.isVisible = false
                binding.tvEmpty.isVisible = true
            } else {
                binding.RV.isVisible = true
                binding.tvEmpty.isVisible = false
                adapterRv.submitList(it)
            }
        }

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(ShowNoteFragmentDirections.actionShowNoteFragmentToAddElementFragment())
        }
    }

    private fun showDialog(note: Note){
        val alertDialog=AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Alert To Clicked")
        alertDialog.setMessage("checked")
        alertDialog.setPositiveButton("Edit") { _: DialogInterface, _: Int ->
            findNavController().navigate(
                ShowNoteFragmentDirections.actionShowNoteFragmentToChangeElementFragment(
                    note.id!!, note.nameNote, note.note
                )
            )
        }
        alertDialog.setNegativeButton("Delete") { _: DialogInterface, _: Int ->
            viewModelNote.deleteNote(note)
        }
        alertDialog.show()
    }


}


