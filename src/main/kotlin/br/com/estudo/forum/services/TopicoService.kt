package br.com.estudo.forum.services

import br.com.estudo.forum.dto.AtualizacaoTopicoForm
import br.com.estudo.forum.dto.NovoTopicoForm
import br.com.estudo.forum.dto.TopicoView
import br.com.estudo.forum.exception.NotFoundException
import br.com.estudo.forum.mapper.TopicoFormMapper
import br.com.estudo.forum.mapper.TopicoViewMapper
import br.com.estudo.forum.model.Curso
import br.com.estudo.forum.model.Topico
import br.com.estudo.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado!"
    ) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map {t -> topicoViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter({
            t -> t.id == id
        }).findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream().filter({
                t -> t.id == form.id
        }).findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            curso = topico.curso,
            autor = topico.autor,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter({
                t -> t.id == id
        }).findFirst().get()
        topicos = topicos.minus(topico)
    }
}