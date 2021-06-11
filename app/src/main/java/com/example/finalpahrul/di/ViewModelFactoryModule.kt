package com.example.finalpahrul.di

import androidx.lifecycle.ViewModelProvider
import com.example.finalpahrul.vmfactory.StudentViewModelFactory


abstract class ViewModelFactoryModule {


    internal abstract fun bindViewModelFactory(vMFactory : StudentViewModelFactory) : ViewModelProvider.Factory
}