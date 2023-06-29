package com.example.todolist.feautre_note.domain.use_case

import com.example.todolist.feautre_note.domain.model.Note
import com.example.todolist.feautre_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}