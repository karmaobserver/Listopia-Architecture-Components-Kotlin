package com.aleksej.makaji.listopia.error

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
data class ErrorResponse(
        var errorCodes: List<String>,
        var message: String,
        val data: ErrorData?
)

data class ErrorData(var dialogType: String?,
                     var info: DialogTypeInfo?)

data class DialogTypeInfo(
        var mailTo: String?,
        var subject: String?,
        var plainTextContent: String?
)