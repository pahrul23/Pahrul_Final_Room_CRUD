package com.example.finalpahrul.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.finalpahrul.entity.Student
import io.reactivex.Flowable
import java.nio.charset.CodingErrorAction.REPLACE


@Dao
interface StudentDao {
    @Query("SELECT * from students")
    fun getAll(): Flowable<List<Student>>

    @Query("SELECT * FROM students WHERE id = :id ")
    fun getById(id: String): Flowable<Student>

    @Insert(onConflict = REPLACE)
    fun insert(student: Student)

    @Delete
    fun delete(student: Student)

    @Query("UPDATE students SET name =:studentName, nim =:studentNim, gender =:studentGen WHERE id =:studentId")
    fun update(studentId: Long, studentName:String, studentNim:String, studentGen:String)
}