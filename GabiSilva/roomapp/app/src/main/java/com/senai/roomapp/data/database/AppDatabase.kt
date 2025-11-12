package com.senai.roomapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.senai.roomapp.data.dao.UsuarioDao
import com.senai.roomapp.data.entity.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
}
