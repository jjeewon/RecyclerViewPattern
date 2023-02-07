package com.jjeewon.recyclerviewpattern.data.api

import com.jjeewon.recyclerviewpattern.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}