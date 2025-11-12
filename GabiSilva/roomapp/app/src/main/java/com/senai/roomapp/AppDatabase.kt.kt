package com.senai.roomapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.senai.roomapp.data.entity.Usuario
import com.senai.roomapp.data.dao.UsuarioDao

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
}
