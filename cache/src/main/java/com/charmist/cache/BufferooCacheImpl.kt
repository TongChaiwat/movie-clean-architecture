package com.charmist.cache

import android.database.sqlite.SQLiteDatabase
import com.charmist.cache.db.Db
import com.charmist.cache.db.DbOpenHelper
import com.charmist.cache.db.constants.BufferooConstants
import com.charmist.cache.db.mapper.BufferooMapper
import com.charmist.cache.mapper.BufferooEntityMapper
import com.charmist.data.model.BufferooEntity
import com.charmist.data.repository.BufferooCache
import io.reactivex.Completable
import io.reactivex.Single
import org.buffer.android.boilerplate.cache.PreferencesHelper
import org.buffer.android.boilerplate.cache.model.CachedBufferoo
import javax.inject.Inject


class BufferooCacheImpl @Inject constructor(
    dbOpenHelper: DbOpenHelper,
    private val entityMapper: BufferooEntityMapper,
    private val mapper: BufferooMapper,
    private val preferencesHelper: PreferencesHelper
) :
    BufferooCache {

    private val EXPIRATION_TIME = (60 * 10 * 1000).toLong()

    private var database: SQLiteDatabase = dbOpenHelper.writableDatabase

    internal fun getDatabase(): SQLiteDatabase {
        return database
    }

    override fun clearBufferoos(): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                database.delete(Db.BufferooTable.TABLE_NAME, null, null)
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                bufferoos.forEach {
                    saveBufferoo(entityMapper.mapToCached(it))
                }
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return Single.defer<List<BufferooEntity>> {
            val updatesCursor = database.rawQuery(BufferooConstants.QUERY_GET_ALL_BUFFEROOS, null)
            val bufferoos = mutableListOf<BufferooEntity>()

            while (updatesCursor.moveToNext()) {
                val cachedBufferoo = mapper.parseCursor(updatesCursor)
                bufferoos.add(entityMapper.mapFromCached(cachedBufferoo))
            }

            updatesCursor.close()
            Single.just<List<BufferooEntity>>(bufferoos)
        }
    }

    private fun saveBufferoo(cachedBufferoo: CachedBufferoo) {
        database.insert(Db.BufferooTable.TABLE_NAME, null, mapper.toContentValues(cachedBufferoo))
    }

    override fun isCached(): Boolean {
        return database.rawQuery(BufferooConstants.QUERY_GET_ALL_BUFFEROOS, null).count > 0
    }

    override fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    override fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }

}