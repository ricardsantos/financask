package br.com.ricardsantos.financask.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.ricardsantos.financask.R
import br.com.ricardsantos.financask.extension.formataParaBrasileiro
import br.com.ricardsantos.financask.extension.limitaEmAte
import br.com.ricardsantos.financask.model.Tipo
import br.com.ricardsantos.financask.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(
    private val transacoes: List<Transacao>,
    private val context: Context) : BaseAdapter() {

    private val limitaCategoria = 14

    override fun getItem(posicao: Int): Transacao {
        return transacoes[posicao]

    }

    override fun getItemId(posicao: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size

    }

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[posicao]

        adicionaValor(transacao, viewCriada)

        adicionaIcone(transacao, viewCriada)

        viewCriada.transacao_categoria.text = transacao.categoria.limitaEmAte(limitaCategoria)

        viewCriada.transacao_data.text = transacao.data.formataParaBrasileiro()

        return viewCriada
    }

    private fun adicionaIcone(transacao: Transacao, viewCriada: View) {
        val icone = iconePor(transacao.tipo)
        viewCriada.transacao_icone
            .setBackgroundResource(icone)
    }

    private fun iconePor(tipo: Tipo) : Int {
        if (tipo == Tipo.RECEITA) return R.drawable.icone_transacao_item_receita
        return R.drawable.icone_transacao_item_despesa

    }

    private fun adicionaValor(transacao: Transacao, viewCriada: View) {
        val cor : Int = corPor(transacao.tipo)

        viewCriada.transacao_valor
            .setTextColor(ContextCompat.getColor(context, cor))

        viewCriada.transacao_valor.text = transacao.valor.formataParaBrasileiro()
    }

    private fun corPor(tipo: Tipo): Int {
        if (tipo == Tipo.RECEITA) return  R.color.receita
        return R.color.despesa
    }


}