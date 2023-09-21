package com.example.chatcompose.di

import com.example.chatcompose.data.repo.ChatRepository
import com.example.chatcompose.data.repo.ChatRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindChatRepository(chatRepositoryImpl: ChatRepositoryImpl): ChatRepository
}