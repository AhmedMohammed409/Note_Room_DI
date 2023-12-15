package com.example.note_room_di.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_room_di.models.Note
import com.example.note_room_di.repositry.RepositoryImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private var repositoryImplementation: RepositoryImplementation) :
    ViewModel() {

    val list = repositoryImplementation.getAllMassage()

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryImplementation.addMassage(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryImplementation.deleteMassage(note)
        }
    }
}