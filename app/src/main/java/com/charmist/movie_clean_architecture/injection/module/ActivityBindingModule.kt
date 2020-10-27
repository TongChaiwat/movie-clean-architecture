package com.charmist.movie_clean_architecture.injection.module

import com.charmist.movie_clean_architecture.browse.BrowseActivity
import com.charmist.movie_clean_architecture.injection.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(BrowseActivityModule::class))
    abstract fun bindMainActivity(): BrowseActivity

}