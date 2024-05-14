package com.baitent.thenews.domain.manger

interface LocalUserManger {

    suspend fun saveAppEntry()

    fun readAppEntry(): kotlinx.coroutines.flow.Flow<Boolean>
}