package com.example.todolist.feautre_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todolist.ui.theme.Blue
import com.example.todolist.ui.theme.Green
import com.example.todolist.ui.theme.Pink
import com.example.todolist.ui.theme.Red
import com.example.todolist.ui.theme.Yellow

@Entity
data class Note(
    val title: String,
    val content:String,
    val timestamp: Long,
    val Color: Int,
    @PrimaryKey val id: Int?=null
){
    companion object{
        val noteColors = listOf( Red, Pink, Blue, Yellow, Green)
    }

}
class InvalidNoteException(message: String): Exception(message)
