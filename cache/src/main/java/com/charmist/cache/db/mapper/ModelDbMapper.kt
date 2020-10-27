package com.charmist.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor

interface ModelDbMapper<T> {

    fun toContentValues(model: T): ContentValues

    fun parseCursor(cursor: Cursor): T

}