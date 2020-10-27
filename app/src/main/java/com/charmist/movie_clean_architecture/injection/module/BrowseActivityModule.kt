package com.charmist.movie_clean_architecture.injection.module

import com.charmist.domain.interactor.browse.GetBufferoos
import com.charmist.movie_clean_architecture.browse.BrowseActivity
import com.charmist.movie_clean_architecture.injection.scopes.PerActivity
import com.charmist.presentation.browse.BrowseBufferoosContract
import com.charmist.presentation.browse.BrowseBufferoosPresenter
import com.charmist.presentation.mapper.BufferooMapper
import dagger.Module
import dagger.Provides

@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): BrowseBufferoosContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(
        mainView: BrowseBufferoosContract.View,
        getBufferoos: GetBufferoos, mapper: BufferooMapper
    ):
            BrowseBufferoosContract.Presenter {
        return BrowseBufferoosPresenter(mainView, getBufferoos, mapper)
    }

}
