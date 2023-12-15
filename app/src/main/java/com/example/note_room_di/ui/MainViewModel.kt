package com.example.note_room_di.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_room_di.model.entity.Note
import com.example.note_room_di.model.repositry.RepositoryImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private var repositoryImplementation: RepositoryImplementation) : ViewModel() {

    private var notesMutableLiveData = MutableLiveData<List<Note>>()
    val notesLiveData: LiveData<List<Note>> get() = notesMutableLiveData

    private fun getAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
                notesMutableLiveData.postValue(repositoryImplementation.getAllMassage())


        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
                repositoryImplementation.addMassage(note)
                getAllNotes()

        }
    }

   fun delateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryImplementation.deleteMassage(note)
        }
    }
}