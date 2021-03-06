package com.example.todo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {
    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)
}