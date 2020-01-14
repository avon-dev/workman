package com.example.workman.Model

interface IUser {
    val email: String
    val password:String
    fun isDataValid():Int
}