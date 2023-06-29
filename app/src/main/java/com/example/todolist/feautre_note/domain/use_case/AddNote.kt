package com.example.todolist.feautre_note.domain.use_case

import com.example.todolist.feautre_note.domain.model.InvalidNoteException
import com.example.todolist.feautre_note.domain.model.Note
import com.example.todolist.feautre_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note:Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("Заголовок заметки не может быть пустым.")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("Содержание заметки не может быть пустое.")
        }
        repository.insertNote(note)
    }
}