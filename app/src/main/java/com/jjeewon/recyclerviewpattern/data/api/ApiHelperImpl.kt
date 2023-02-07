package com.jjeewon.recyclerviewpattern.data.api

import com.jjeewon.recyclerviewpattern.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): List<User> = apiService.getUsers()

}