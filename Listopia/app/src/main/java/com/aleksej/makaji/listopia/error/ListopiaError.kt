package com.aleksej.makaji.listopia.error

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
sealed class ListopiaError
//GLOBAL ERROR
object UnknownError : ListopiaError()
//DATABASE ERROR
object RoomError: ListopiaError()
object RoomDeletingError: ListopiaError()
//API ERROR
data class ThrowableError(val throwable: Throwable) : ListopiaError()
data class BackendError(val error: ErrorResponse) : ListopiaError()