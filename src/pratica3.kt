class pratica3 {
    /*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

    val materiasENotas = mutableMapOf<String, MutableList<Double>>()

    /**
     * Adiciona uma disciplina no dicionário mutável,
     * Recebe um array de notas (opcional)
     * Retorna true se conseguiu, false se não.
     */
    fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
        return materiasENotas.put(materia, notas) != null
    }

    /**
     * Adiciona uma nota à lista de notas de uma determinada matéria;
     * Retorna true se conseguiu adicionar, false se não conseguiu.
     */
    fun adicionarNota(materia: String, nota: Double): Boolean {
        val notasDaMateria = materiasENotas[materia]

        return if (notasDaMateria != null) {
            notasDaMateria.add(nota)
            true
        } else {
            false
        }
    }



    /**
     *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
     * Materia: {nome da materia}
     * Nota 1: 5.4 \n
     * Nota 2: 7.8 \n
     * ...
     * Nota n: 10.0 \n
     * \n
     * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
     * \n
     *
     * Caso não encontre a materia no map, mostre:
     * Materia {nome da materia} não encontrada \n
     *
     * Caso não seja possível mostar as notas, mostre:
     * Não foi possível mostrar as notas da matéria {nome da materia} \n
     */
    fun mostrarNotas(materia: String) {
        val notas = materiasENotas[materia]
        if (notas != null) {
            println("Notas da disciplina $materia:")
            var cont = 1
            for (nota in notas) {
                println("Nota ${cont++}: $nota")
            }
            val media = calcularMedia(materia)
            println("Média da disciplina $materia: %.2f".format(media))
        } else {
            println("Disciplina $materia não encontrada.")
        }
    }

    /*Retorna a média obtida apartir de uma lista de notas */
    fun calcularMedia(disciplina: String): Double {
        val notas = materiasENotas[disciplina] ?: return 0.0
        return if (notas.isNotEmpty()) {
            notas.sum() / notas.size
        } else {
            0.0
        }
    }


    /**
     *Adiciona várias notas de uma só vez em uma matéria
     * retorne true se conseguiu adicionar, false se não consegiu.
     * */
    fun adicionarVariasNotas(materia:String, vararg notas:Double) {
        val notasDaMateria = materiasENotas[materia] ?: mutableListOf()
        notasDaMateria.addAll(notas.toList())
        materiasENotas[materia] = notasDaMateria
    }

}

fun main(){
    val pratica = pratica3()

    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    pratica.adicionarDisciplina("Matemática", mutableListOf(8.0, 9.0, 7.5))
    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    pratica.adicionarDisciplina(materia = "Português", notas = mutableListOf(8.5, 7.0, 9.5))
    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    pratica.adicionarDisciplina("Física")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    pratica.adicionarNota("Matemática", 6.5)
    pratica.adicionarNota("Matemática", 7.5)
    pratica.adicionarNota("Matemática", 8.5)
    pratica.adicionarNota("Português", 8.0)
    pratica.adicionarNota("Português", 9.0)
    pratica.adicionarNota("Português", 7.0)
    pratica.adicionarNota("Física", 7.5)
    pratica.adicionarNota("Física", 8.5)
    pratica.adicionarNota("Física", 9.5)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    pratica.mostrarNotas("Matemática")
    pratica.mostrarNotas("Português")
    pratica.mostrarNotas("Física")


    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    pratica.adicionarDisciplina("Química")

    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    pratica.adicionarVariasNotas("Química", 6.0, 7.0, 8.0)


    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    pratica.mostrarNotas("Química")

    // Bônus: (Não vai ganhar nada, ou melhor mais ganhar mais conhecimento >:O)

    // 11: calcularMedia -> Implemente a função calcularMedia()

    // 12: calcularMedia -> calcule a media de 2 disciplinas
    pratica.calcularMedia("Matemática")

    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas

    // 14: mostrarNotas -> mostre as notas de 1 disciplina
    pratica.mostrarNotas("Física")
    pratica.mostrarNotas("Geografia")

}