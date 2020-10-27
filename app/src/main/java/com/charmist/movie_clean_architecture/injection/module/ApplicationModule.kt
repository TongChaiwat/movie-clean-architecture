package com.charmist.movie_clean_architecture.injection.module

import android.app.Application
import android.content.Context
import com.charmist.cache.BufferooCacheImpl
import com.charmist.cache.db.DbOpenHelper
import com.charmist.cache.mapper.BufferooEntityMapper
import com.charmist.data.BufferooDataRepository
import com.charmist.data.executor.JobExecutor
import com.charmist.data.mapper.BufferooMapper
import com.charmist.data.repository.BufferooCache
import com.charmist.data.repository.BufferooRemote
import com.charmist.data.source.BufferooDataStoreFactory
import com.charmist.domain.executor.PostExecutionThread
import com.charmist.domain.executor.ThreadExecutor
import com.charmist.domain.repository.BufferooRepository
import com.charmist.movie_clean_architecture.BuildConfig
import com.charmist.movie_clean_architecture.UiThread
import com.charmist.movie_clean_architecture.injection.scopes.PerApplication
import com.charmist.remote.BufferooRemoteImpl
import com.charmist.remote.BufferooService
import com.charmist.remote.BufferooServiceFactory
import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.cache.PreferencesHelper

@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }


    @Provides
    @PerApplication
    internal fun provideBufferooRepository(
        factory: BufferooDataStoreFactory,
        mapper: BufferooMapper
    ): BufferooRepository {
        return BufferooDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(
        factory: DbOpenHelper,
        entityMapper: BufferooEntityMapper,
        mapper: com.charmist.cache.db.mapper.BufferooMapper,
        helper: PreferencesHelper
    ): BufferooCache {
        return BufferooCacheImpl(factory, entityMapper, mapper, helper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(
        service: BufferooService,
        factory: com.charmist.remote.mapper.BufferooEntityMapper
    ): BufferooRemote {
        return BufferooRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideBufferooService(): BufferooService {
        return BufferooServiceFactory.makeBuffeoorService(BuildConfig.DEBUG)
    }
}
