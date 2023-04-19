package com.example.viikko12;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class Purchase {

    String name;
    String reminder;
    LocalDateTime time;

    Boolean superImportant;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Purchase(String name, String reminder, Boolean superImportant) {
        this.name = name;
        this.reminder = reminder;
        this.superImportant = superImportant;
        this.time = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public String getName() {
        return name;
    }

    public String getReminder() {
        return reminder;
    }

    public LocalDateTime getTime() {
        return time;
    }

}
