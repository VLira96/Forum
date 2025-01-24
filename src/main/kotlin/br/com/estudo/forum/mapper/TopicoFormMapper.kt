package br.com.estudo.forum.mapper

import br.com.estudo.forum.dto.NovoTopicoForm
import br.com.estudo.forum.model.Topico
import br.com.estudo.forum.services.CursoService
import br.com.estudo.forum.services.UsuarioService
import org.springframework.stereotype.Component

@Component
data class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}