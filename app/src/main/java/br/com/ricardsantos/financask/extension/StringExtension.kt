package br.com.ricardsantos.financask.extension

fun String.limitaEmAte(caracteres: Int) : String{
    if(this.length> caracteres) {
        val primeiroCaracter = 0
        return "${this.substring(primeiroCaracter,caracteres)}..."
    } else return this
}