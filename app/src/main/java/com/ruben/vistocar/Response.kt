package com.ruben.vistocar

data class Response (val status: String, val msg: String){
    fun isOK(): Boolean {return "OK".equals(status, ignoreCase = true)
    }
}