package com.charmist.presentation.browse

import com.charmist.presentation.BasePresenter
import com.charmist.presentation.BaseView
import com.charmist.presentation.model.BufferooView

interface BrowseBufferoosContract {

    interface View : BaseView<Presenter> {
        fun showProgress()
        fun hideProgress()
        fun showBufferoos(bufferoos: List<BufferooView>)
        fun hideBufferoos()
        fun showErrorState()
        fun hideErrorState()
        fun showEmptyState()
        fun hideEmptyState()
    }

    interface Presenter : BasePresenter {
        fun retrieveBufferoos()
    }

}