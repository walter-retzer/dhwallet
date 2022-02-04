package com.digitalhouse.dhwallet.model

class GroupTransaction(
    val type: GroupTypeTransaction,  // tipo do dado enviado
    val data: String? = null,  //variável para exibir a data
    val title: String? = null,  //título do pagamento
    val subtitle: String? = null, //subtitulo do pagamento
    val value: String? = null,  //valor do pagamento
    val sinal: GroupSinalValor? = null,  //sinal de - para os valor R$
    val imagem: Int? = null  //imagem do icone do pagamento
)

// implementada classe para exibir o tipo de conteúdo: header, data ou conteúdo
enum class GroupTypeTransaction {
    HEADER,  //cabeçalho
    DATA,  //data
    CONTENT,  //contéudo
}

// implementado classe para envio do sinal do valor R$
enum class GroupSinalValor {
    SINAL
}
