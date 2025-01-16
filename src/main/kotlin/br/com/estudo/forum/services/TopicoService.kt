package br.com.estudo.forum.services

import br.com.estudo.forum.model.Curso
import br.com.estudo.forum.model.Topico
import br.com.estudo.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico = Topico(
            id = 1,
            titulo = "Duvidas Kotlin",
            mensagem = "Variáveis no Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação",
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "teste@teste.com"
            )
        )
        val topico2 = Topico(
            id = 2,
            titulo = "Duvidas Kotlin 2",
            mensagem = "Variáveis no Kotlin 2",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação",
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "teste@teste.com"
            )
        )
        val topico3 = Topico(
            id = 3,
            titulo = "Duvidas Kotlin 3",
            mensagem = "Variáveis no Kotlin 3",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação",
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "teste@teste.com"
            )
        )
        topicos = Arrays.asList(topico, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }
}