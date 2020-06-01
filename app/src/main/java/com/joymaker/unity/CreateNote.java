package com.joymaker.unity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNote extends AppCompatActivity {
    private EditText title,description;
    private NotesDBHelper dbHelper;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        setTitle("Создание заметки");
        title = findViewById(R.id.editText);
        description = findViewById(R.id.editText2);
        dbHelper = new NotesDBHelper(getApplicationContext());
        database = dbHelper.getWritableDatabase();
    }

    public void AddNote(View v) {
        if(title.getText().toString().isEmpty() && description.getText().toString().isEmpty()) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE,title.getText().toString());
        contentValues.put(NotesContract.NotesEntry.COLUMN_DESCRIPTION,description.getText().toString());
        database.insert(NotesContract.NotesEntry.TABLE_NAME,null,contentValues);
        database.close();
        Toast.makeText(this, "Заметка добавлена!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void closeCreateNote(View v) {
        finish();
    }
}
