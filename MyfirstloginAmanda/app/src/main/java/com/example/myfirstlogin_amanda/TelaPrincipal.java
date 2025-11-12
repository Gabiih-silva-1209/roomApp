package com.example.myfirstlogin_amanda;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
class TelaPrincipal : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        val nomeUsuario = intent.getStringExtra("NOME_USUARIO")
        val tvMensagem = findViewById<TextView>(R.id.tv_mensagem_boas_vindas)

        if (nomeUsuario != null) {
            tvMensagem.text = "Bem-vindo(a), $nomeUsuario!"
        } else {
            tvMensagem.text = "Bem-vindo(a)!"
        }
    }
}
