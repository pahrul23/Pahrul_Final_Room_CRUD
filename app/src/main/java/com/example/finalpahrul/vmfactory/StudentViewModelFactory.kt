package com.example.finalpahrul.vmfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.security.Provider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


class StudentViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards java.security.Provider<ViewModel>>)
    : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?:
        creators.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
        ?: throw IllegalArgumentException("unknown model class $modelClass")

        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}