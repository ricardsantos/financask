package br.com.ricardsantos.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import br.com.ricardsantos.financask.R
import br.com.ricardsantos.financask.model.Tipo
import br.com.ricardsantos.financask.model.Transacao
import br.com.ricardsantos.financask.ui.ResumoView
import br.com.ricardsantos.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = transacoesExemplo()
        configuraResumo(transacoes)
        configuraListaTransacoes(transacoes)

        lista_transacoes_adiciona_receita
            .setOnClickListener {
                Toast.makeText(this     ,
                    "click de receita funcionou",
                    Toast.LENGTH_LONG).show()
            }

    }

    private fun configuraResumo(transacoes: List<Transacao>) {
        val view: View = window.decorView
        val resumoView = ResumoView(this, view, transacoes)
        resumoView.atualiza()
    }

    private fun configuraListaTransacoes(transacoes: List<Transacao>) {
        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(transacoes, this))
    }

    private fun transacoesExemplo(): List<Transacao> {
        return listOf(
            Transacao(
                valor = BigDecimal(100.0),
                categoria = "combustível",
                tipo = Tipo.DESPESA
            ),
            Transacao(
                valor = BigDecimal(1236.0),
                tipo = Tipo.RECEITA
            )
            ,
            Transacao(
                valor = BigDecimal(600.0),
                tipo = Tipo.DESPESA,
                categoria = "almoço de final de semana na casa da mamae"
            )
        )
    }
}