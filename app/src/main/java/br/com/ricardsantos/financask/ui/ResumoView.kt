package br.com.ricardsantos.financask.ui

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import br.com.ricardsantos.financask.R
import br.com.ricardsantos.financask.extension.formataParaBrasileiro
import br.com.ricardsantos.financask.model.Resumo
import br.com.ricardsantos.financask.model.Tipo
import br.com.ricardsantos.financask.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.*
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumoView(private val context: Context ,
                 private val view: View,
                 transacoes: List<Transacao>) {

    private val resumo : Resumo = Resumo(transacoes)
    private val corReceita = ContextCompat.getColor(context, R.color.receita)
    private val CorDespesa = ContextCompat.getColor(context, R.color.despesa)

    fun atualiza(){
        adicionaReceita()
        adicionaDespesa()
        adicionaTotal()
    }

    private fun adicionaReceita() {
        with(view.resumo_card_receita){
            setTextColor(corReceita)
            text = resumo.receita.formataParaBrasileiro()
        }
    }

    private fun adicionaDespesa() {
        with(view.resumo_card_despesa){
            setTextColor(CorDespesa)
            text = resumo.despesa.formataParaBrasileiro()
        }

    }
    private fun adicionaTotal(){
        val cor  = corPor(resumo.total)
        with(view.resumo_card_total){
            text = resumo.total.formataParaBrasileiro()
            setTextColor(cor)
        }
    }

    private fun corPor(valor: BigDecimal): Int {
        if (valor >= BigDecimal.ZERO)
            return corReceita
        return CorDespesa
    }
}