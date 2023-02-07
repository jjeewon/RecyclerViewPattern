package com.jjeewon.recyclerviewpattern.data.usecase

import com.jjeewon.recyclerviewpattern.data.model.User
import com.jjeewon.recyclerviewpattern.data.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val mainRepository: MainRepository,
): UseCase<Unit, GetUserListUseCase.Result>(coroutineDispatcher){
    override suspend fun execute(parameters: Unit): Result {
        val list = mainRepository.getUsers()
        return Result(
            list = list,
        )
    }

    data class Result(
        val list: List<User>
    )
}