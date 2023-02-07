package com.jjeewon.recyclerviewpattern.data.usecase

import com.jjeewon.recyclerviewpattern.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<in P, out R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P): Resource<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    Resource.Success(it)
                }
            }
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}