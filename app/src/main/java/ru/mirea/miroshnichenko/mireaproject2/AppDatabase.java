package ru.mirea.miroshnichenko.mireaproject2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {HistoryItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract HistoryItemDao historyItemDaoDao();
}