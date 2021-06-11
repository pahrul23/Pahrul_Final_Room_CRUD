package com.example.finalpahrul.features.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.finalpahrul.db.repsitory.LocalRepository
import com.example.finalpahrul.entity.Student
import com.example.finalpahrul.features.base.BaseViewModel


class DetailViewModel @ViewModelInject constructor(private val localRepository: LocalRepository): BaseViewModel() {

    val mTriger : MutableLiveData<String> = MutableLiveData()
    val student : LiveData<Student> = Transformations.switchMap(mTriger) {
        localRepository.getDataById(it)
    }

    fun getStudentbyId() = student

    fun triggerFetchData(id: String){
        mTriger.value = id
    }

    fun deleteData(student: Student){
        localRepository.deleteData(student)
    }

    fun updateData(id: Long, name: String, nim: String, gen: String){
        localRepository.updateData(id, name, nim, gen)
    }

}