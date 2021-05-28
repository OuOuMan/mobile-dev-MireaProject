package ru.mirea.miroshnichenko.mireaproject2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HistoryItem {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String title;
    public String text;
    public String hashtag;
}
