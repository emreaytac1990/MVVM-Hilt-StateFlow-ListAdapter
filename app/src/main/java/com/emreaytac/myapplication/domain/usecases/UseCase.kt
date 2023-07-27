package com.emreaytac.myapplication.domain.usecases

interface UseCase<R,T> {
    suspend fun execute(param: R): T
}