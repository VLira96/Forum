package br.com.estudo.forum.mapper

import br.com.estudo.forum.dto.TopicoView
import br.com.estudo.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
        return TopicoView(t.id, t.titulo, t.mensagem, t.status, t.dataCriacao)
    }
}