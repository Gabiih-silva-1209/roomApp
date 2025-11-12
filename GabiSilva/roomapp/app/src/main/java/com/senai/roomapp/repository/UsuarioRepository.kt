package com.senai.roomapp.repository

import com.senai.roomapp.data.dao.UsuarioDao
import com.senai.roomapp.data.entity.Usuario

class UsuarioRepository(private val dao: UsuarioDao) {
    fun listarUsuarios() = dao.listarTodos()
    suspend fun inserirUsuario(usuario: Usuario) = dao.inserir(usuario)
    suspend fun deletarUsuario(usuario: Usuario) = dao.deletar(usuario)
}