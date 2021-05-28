package ru.mirea.miroshnichenko.mireaproject2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HistoryItemDao {
    @Query("SELECT * FROM HistoryItem")
    List<HistoryItem> getAll();
    @Query("SELECT * FROM HistoryItem WHERE id = :id")
    HistoryItem getById(long id);
    @Insert
    void insert(HistoryItem employee);
    @Update
    void update(HistoryItem employee);
    @Delete
    void delete(HistoryItem employee);
}
