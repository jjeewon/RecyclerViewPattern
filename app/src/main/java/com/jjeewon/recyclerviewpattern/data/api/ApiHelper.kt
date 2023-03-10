package com.jjeewon.recyclerviewpattern.data.api

import com.jjeewon.recyclerviewpattern.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): List<User>
}