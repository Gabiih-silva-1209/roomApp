package com.senai.roomapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.senai.roomapp.data.database.AppDatabase
import com.senai.roomapp.data.ui.viewModel.UsuarioViewModel
import com.senai.roomapp.repository.UsuarioRepository

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "room_db").build()
        val repository = UsuarioRepository(db.usuarioDao())
        val viewModel = UsuarioViewModel(repository)


        setContent {
            MaterialTheme {
                TelaUsuarios(viewModel)
            }
        }
    }
}

@Composable
fun TelaUsuarios(viewModel: UsuarioViewModel) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val usuarios by viewModel.usuarios.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Cadastro de Usuários", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("E-mail") })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (nome.isNotBlank() && email.isNotBlank()) {
                viewModel.adicionarUsuario(nome, email)
                nome = ""
                email = ""
            }
        }) {
            Text("Adicionar")
        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn {
            items(usuarios) { usuario ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("Nome: ${usuario.nome}")
                        Text("E-mail: ${usuario.email}")
                    }
                }
            }
        }
    }
}
