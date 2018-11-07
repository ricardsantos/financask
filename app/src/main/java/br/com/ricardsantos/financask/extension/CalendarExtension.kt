package br.com.ricardsantos.financask.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formataParaBrasileiro() : String{
    val formatoBrasileiro = "dd/MM/YYYY"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}