fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 0
    while (opcao != 11) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 0
        when (opcao) {
            1 -> {
                println("Digite a idade do cachorro: ")
                val idadeCachorro = readLine()?.toIntOrNull() ?: 0
                println("Digite o nome do cachorro: ")
                val nomeCachorro = readLine() ?: ""
                val cachorro = Cachorro(idadeCachorro, Color.BLUE)
                cachorro.nome = nomeCachorro
                repositorioAnimal.adicionar(cachorro)
            }
            2 -> {
                println("Digite a idade do gato: ")
                val idadeGato = readLine()?.toIntOrNull() ?: 0
                println("Digite o nome do gato: ")
                val nomeGato = readLine() ?: ""
                val gato = Gato(idadeGato, Color.GREEN)
                gato.nome = nomeGato
                repositorioAnimal.adicionar(gato)
            }
            3 -> {
                println("Digite a idade do pássaro: ")
                val idadePassaro = readLine()?.toIntOrNull() ?: 0
                println("Digite o nome do pássaro: ")
                val nomePassaro = readLine() ?: ""
                val passaro = Passaro(idadePassaro, Color.RED)
                passaro.nome = nomePassaro
                repositorioAnimal.adicionar(passaro)
            }
            4 -> {
                repositorioAnimal.listar()
            }
            5 -> {
                repositorioAnimal.animais.forEach(Animal::emitirSom)
                repositorioAnimal.animais.forEach { it.emitirSom()}
            }

            6 -> {
                val nomeAnimal = readlnOrNull() ?: "nao quero"
                repositorioAnimal.remover(nomeAnimal)
            }

            7 -> {
                println("Digite a cor (RED, GREEN, ou BLUE): ")
                val cor = readlnOrNull()?.uppercase()
                val corSelecionada = Color.valueOf(cor ?: "RED")
                repositorioAnimal.listarPorCor(corSelecionada)
            }
            8 -> {
                println("Digite a idade: ")
                val idade = readlnOrNull()?.toIntOrNull() ?: 0
                repositorioAnimal.listarPorIdade(idade)
            }
            9 -> {
                println("Digite o nome do animal: ")
                val nomeAnimal = readLine() ?: ""
                val animalEncontrado = repositorioAnimal.buscarPorNome(nomeAnimal)
                if (animalEncontrado != null) {
                    println("Animal encontrado: ${animalEncontrado.nome}")
                } else {
                    println("Animal não encontrado.")
                }
            }
            10 -> {
                println("Digite a idade do homem: ")
                val idadeHomem = readLine()?.toIntOrNull() ?: 0
                println("Digite o nome do homem: ")
                val nomeHomem = readLine() ?: ""
                val homem = Homem(idadeHomem, Color.BLUE)
                homem.nome = nomeHomem
                repositorioAnimal.adicionar(homem)
                println("Homem criado com sucesso!")
            }
        }

    }
}

abstract class Animal(var idade: Int, var cor: Color) {
    open var nome: String = ""
        get() = "Animal: $field + $cor"
        set(valor) {
            field = valor
        }

    abstract fun emitirSom()

    open fun idadeEmAnosHumanos(): Int {
        return idade * 7
    }
}

class Cachorro(idade: Int, cor: Color ) : Animal(idade, cor) {
    override var nome: String = ""
        get() = "Cachorro: $field + $cor + ${idadeEmAnosHumanos()}"
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Au au")
    }
}
class Gato(idade: Int, cor: Color) : Animal(idade, cor) {
    override var nome: String = ""
        get() = "Gato: $field + $cor + ${idadeEmAnosHumanos()}"
        set(valor) {
            field = valor
        }

    override fun emitirSom() {
        println("Miau")
    }
}

class Passaro(idade: Int, cor: Color) : Animal(idade, cor) {
    override var nome: String = ""
        get() = "Passaro: $field + $cor + ${idadeEmAnosHumanos()}"
        set(valor) {
            field = valor
        }

    override fun emitirSom() {
        println("Piu piu")
    }
}

fun menu() {
    println("1 - Cachorro")
    println("2 - Gato")
    println("3 - Pássaro")
    println("4 - Listar Animais")
    println("5 - Emitir som")
    println("6 - Remover Animal")
    println("7 - Listar  animal  pela cor")
    println("8 - Listar  animal  pela idade")
    println("9 - Buscar animal  por nome")
    println("10 - Criar Homem")
    println("11 - Sair")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun listar() {
        animais.forEach { println(it.nome) }
    }

    fun remover(nomeAnimal: String): Boolean  {
        val animalARemover = animais.find { it.nome.contains(nomeAnimal)}
        return animais.remove(animalARemover)
    }

    fun listarPorCor(cor: Color) {
        val animaisDaCor = animais.filter { it.cor == cor }
        if (animaisDaCor.isNotEmpty()) {
            println("Animais da cor $cor:")
            animaisDaCor.forEach { println(it.nome) }
        } else {
            println("Não há animais da cor $cor.")
        }
    }

    fun listarPorIdade(idade: Int) {
        val animaisDaIdade = animais.filter { it.idade == idade }
        if (animaisDaIdade.isNotEmpty()) {
            println("Animais com $idade anos de idade:")
            animaisDaIdade.forEach { println(it.nome) }
        } else {
            println("Não há animais com $idade anos de idade.")
        }
    }

    fun buscarPorNome(nome: String): Animal? {
        return animais.find { it.nome.contains(nome) }
    }



}

enum class Color{
    RED,
    GREEN,
    BLUE
}

class Homem(idade: Int, cor: Color) : Animal(idade, cor) {

    override var nome: String = ""
        get() = "Homem: $field + $cor + ${idadeEmAnosHumanos()}"
        set(valor) {
            field = valor
        }

    override fun emitirSom() {
        println("Olá, eu sou um humano.")
    }

    override fun idadeEmAnosHumanos(): Int {
        return idade
    }
}
