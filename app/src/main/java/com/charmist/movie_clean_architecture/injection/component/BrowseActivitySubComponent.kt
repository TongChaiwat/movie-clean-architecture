package com.charmist.movie_clean_architecture.injection.component

import com.charmist.movie_clean_architecture.browse.BrowseActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface BrowseActivitySubComponent : AndroidInjector<BrowseActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BrowseActivity>()

}