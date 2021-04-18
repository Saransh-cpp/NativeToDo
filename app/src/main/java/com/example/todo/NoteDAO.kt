package com.example.todo

import androidx.room.*

@Dao
interface NoteDAO {
    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)
}