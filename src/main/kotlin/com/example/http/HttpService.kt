package com.example.http



interface HttpService {
    fun getClient(): io.ktor.client.HttpClient
}