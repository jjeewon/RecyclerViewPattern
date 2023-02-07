package com.jjeewon.recyclerviewpattern.di

import com.jjeewon.recyclerviewpattern.data.repository.MainRepository
import com.jjeewon.recyclerviewpattern.data.usecase.GetUserListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetUserListUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        mainRepository: MainRepository
    ):GetUserListUseCase {
        return GetUserListUseCase(dispatcher, mainRepository)
    }
}