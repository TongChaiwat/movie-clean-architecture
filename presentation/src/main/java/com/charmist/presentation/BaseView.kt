package com.charmist.presentation

interface BaseView<in T : BasePresenter> {
    fun setPresenter(presenter: T)
}