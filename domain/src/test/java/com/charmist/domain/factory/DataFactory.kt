package com.charmist.domain.factory

class DataFactory {

    companion object Factory {
        fun randomUuid(): String {
            return java.util.UUID.randomUUID().toString()
        }
    }

}