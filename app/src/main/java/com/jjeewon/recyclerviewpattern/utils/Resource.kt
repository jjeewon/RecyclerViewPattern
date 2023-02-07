package com.jjeewon.recyclerviewpattern.utils

sealed interface Resource<out T> {
    data class Success<out T>(val data: T): Resource<T>
    data class Error(val errorMessage: String): Resource<Nothing>
}