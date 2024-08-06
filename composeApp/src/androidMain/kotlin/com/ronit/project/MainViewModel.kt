package com.ronit.project

import androidx.lifecycle.ViewModel
import core.data.repository.DataStoreRepositoryImpl

class MainViewModel(
    private val dataStoreRepository: DataStoreRepositoryImpl
):ViewModel() {
}