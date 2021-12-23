package br.com.dio.motivation.repository

import br.com.dio.motivation.infra.MotivationConstants
import java.util.*

data class Phrase(val description: String, val category: Int)

class Mock {

    private val ALL = MotivationConstants.PHRASEFILTER.ALL
    private val HAPPY = MotivationConstants.PHRASEFILTER.ALL
    private val SUN = MotivationConstants.PHRASEFILTER.ALL

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", HAPPY),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", SUN),
        Phrase("Você perde todas as chances que você não aproveita.", SUN),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", SUN),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", SUN),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", SUN),
        Phrase("Se você acredita, faz toda a diferença.", SUN),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SUN)
    )

    fun getPhrase(categoryId: Int): String{
        val filtered = mListPhrases.filter { it.category == categoryId || it.category == ALL }
        val random = Random().nextInt(filtered.size) // sortear um número de 0 ao tamanho da lista

        return filtered[random].description
    }

}