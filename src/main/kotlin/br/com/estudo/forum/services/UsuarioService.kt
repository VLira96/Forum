package br.com.estudo.forum.services

import br.com.estudo.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
data class UsuarioService(var usuarios: List<Usuario>) {
        init {
            val usuario = Usuario(
                id = 1,
                nome = "Klodoaldo",
                email = "Klodoaldo@email.com"
            )
            usuarios = Arrays.asList(usuario)
        }

        fun buscarPorId(id:Long): Usuario {
            return usuarios.stream().filter({
                    c -> c.id == id
            }).findFirst().get()
        }
}
