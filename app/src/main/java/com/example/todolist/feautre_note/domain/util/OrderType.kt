package com.example.todolist.feautre_note.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
