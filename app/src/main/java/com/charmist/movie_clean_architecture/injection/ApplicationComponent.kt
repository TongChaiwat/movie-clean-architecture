package com.charmist.movie_clean_architecture.injection

import android.app.Application
import com.charmist.movie_clean_architecture.BufferooApplication
import com.charmist.movie_clean_architecture.injection.module.ActivityBindingModule
import com.charmist.movie_clean_architecture.injection.module.ApplicationModule
import com.charmist.movie_clean_architecture.injection.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = arrayOf(
        ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class
    )
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: BufferooApplication)

}
