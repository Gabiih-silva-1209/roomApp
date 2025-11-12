package com.senai.roomapp.data.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senai.roomapp.data.entity.Usuario
import com.senai.roomapp.repository.UsuarioRepository
import kotlinx.coroutines.launch

class UsuarioViewModel(private val repository: UsuarioRepository) : ViewModel() {

    val usuarios = repository.listarUsuarios()

    fun adicionarUsuario(nome: String, email: String) {
        viewModelScope.launch {
            repository.inserirUsuario(Usuario(nome = nome, email = email))
        }
    }

    fun deletarUsuario(usuario: Usuario) {
        viewModelScope.launch {
            repository.deletarUsuario(usuario)
        }
    }
}