package com.example.listadetarefas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var nomeTarefaEditText: EditText
    private lateinit var botaoSalvar: Button
    private lateinit var listaTarefasListView: ListView
    private lateinit var tarefas: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nomeTarefaEditText = findViewById(R.id.nomeTarefa)
        botaoSalvar = findViewById(R.id.botaoSalvar)
        listaTarefasListView = findViewById(R.id.listaTarefas)

        tarefas = ArrayList()
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, tarefas)

        listaTarefasListView.adapter = adapter

        botaoSalvar.setOnClickListener{
            val nomeTarefa = nomeTarefaEditText.text.toString()
            if(nomeTarefa.isNotEmpty()){
                adicionarTarefa(nomeTarefa)
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.salvar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun adicionarTarefa(nomeTarefa: String){
        tarefas.add(nomeTarefa)
        adapter.notifyDataSetChanged()
        nomeTarefaEditText.text.clear()
    }
}