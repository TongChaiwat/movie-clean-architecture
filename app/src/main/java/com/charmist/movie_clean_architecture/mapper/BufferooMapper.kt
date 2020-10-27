package com.charmist.movie_clean_architecture.mapper

import com.charmist.movie_clean_architecture.model.BufferooViewModel
import com.charmist.presentation.model.BufferooView
import javax.inject.Inject

open class BufferooMapper @Inject constructor() : Mapper<BufferooViewModel, BufferooView> {

    override fun mapToViewModel(type: BufferooView): BufferooViewModel {
        return BufferooViewModel(type.name, type.title, type.avatar)
    }

}