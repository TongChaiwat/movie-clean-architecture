package com.charmist.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor
import com.charmist.cache.db.Db
import org.buffer.android.boilerplate.cache.model.CachedBufferoo
import javax.inject.Inject

class BufferooMapper @Inject constructor() : ModelDbMapper<CachedBufferoo> {

    override fun toContentValues(model: CachedBufferoo): ContentValues {
        val values = ContentValues()
        values.put(Db.BufferooTable.NAME, model.name)
        values.put(Db.BufferooTable.TITLE, model.title)
        values.put(Db.BufferooTable.AVATAR, model.avatar)
        return values
    }

    override fun parseCursor(cursor: Cursor): CachedBufferoo {
        val name = cursor.getString(cursor.getColumnIndexOrThrow(Db.BufferooTable.NAME))
        val title = cursor.getString(cursor.getColumnIndexOrThrow(Db.BufferooTable.TITLE))
        val avatar = cursor.getString(cursor.getColumnIndexOrThrow(Db.BufferooTable.AVATAR))
        return CachedBufferoo(name, title, avatar)
    }

}