package br.com.estudo.forum.exception

import java.lang.RuntimeException

class NotFoundException(message: String?): RuntimeException(message) {

}