package com.senai.roomapp.data.dao

import androidx.room.*
import com.senai.roomapp.data.entity.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(usuario: Usuario)

    @Query("SELECT * FROM usuarios ORDER BY id DESC")
    fun listarTodos(): Flow<List<Usuario>>

    @Delete
    suspend fun deletar(usuario: Usuario)
}
