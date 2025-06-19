package com.czy.helloworldandroid

import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("users") // BASE_URL + "users" --> https://dummyjson.com/users
    suspend fun getUsers(): UserResponse

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): UserResponse
}