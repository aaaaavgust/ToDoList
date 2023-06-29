package com.example.todolist.di

import android.app.Application
import androidx.room.Room
import com.example.todolist.feautre_note.data.data_source.NoteDatabase
import com.example.todolist.feautre_note.data.repository.NoteRepositoryImpl
import com.example.todolist.feautre_note.domain.repository.NoteRepository
import com.example.todolist.feautre_note.domain.use_case.AddNote
import com.example.todolist.feautre_note.domain.use_case.DeleteNote
import com.example.todolist.feautre_note.domain.use_case.GetNote
import com.example.todolist.feautre_note.domain.use_case.GetNotes
import com.example.todolist.feautre_note.domain.use_case.NoteUseCases
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @dagger.Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }
    @dagger.Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @dagger.Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}