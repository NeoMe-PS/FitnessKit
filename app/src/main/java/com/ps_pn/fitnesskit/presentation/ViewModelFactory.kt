package com.ps_pn.fitnesskit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
private val viewModelsProviders: @JvmSuppressWildcards Map< Class <out ViewModel>,Provider<ViewModel>>
):ViewModelProvider.Factory{


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelsProviders[modelClass]?.get() as T
    }
}