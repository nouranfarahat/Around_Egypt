package com.example.a34ml.utilities


sealed class ApiState<out T> {
    class Success<T>(val data: T) : ApiState<T>()
    class Failure(val msg: Throwable) : ApiState<Nothing>()
    object Loading : ApiState<Nothing>()

}