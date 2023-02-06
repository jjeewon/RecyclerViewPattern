package com.jjeewon.recyclerviewpattern.data.repository

import com.jjeewon.recyclerviewpattern.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  apiHelper.getUsers()

}