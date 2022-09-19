package com.example.atomic.di

import com.example.atomic.MainApplication
import com.example.atomic.repo.ContentRepository
import com.example.atomic.repo.ContentRepositoryImpl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface  RepositoryModules {
    @Binds
    fun provideContentRepositoryImpl(repository: ContentRepositoryImpl): ContentRepository
}