package br.com.estudo.forum.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}