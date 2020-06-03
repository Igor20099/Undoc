package com.joymaker.unity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.joymaker.unity.interfaceunity.InterfaceUnityActivity;

public class EditNote extends AppCompatActivity {
    private EditText editText,editText2;
    NotesDBHelper dbHelper;
    SQLiteDatabase database;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Редактирование заметки");
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        id = getIntent().getIntExtra("id",-1);
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("desc");
        editText.setText(title);
        editText2.setText(description);
        dbHelper = new NotesDBHelper(getApplicationContext());
        database = dbHelper.getWritableDatabase();

    }

    public void saveNote(View v) {
        if(editText.getText().toString().trim().isEmpty() || editText2.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Поля для ввода не могут быть пустыми!", Toast.LENGTH_SHORT).show();
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE,editText.getText().toString());
        contentValues.put(NotesContract.NotesEntry.COLUMN_DESCRIPTION,editText2.getText().toString());
        String where = NotesContract.NotesEntry._ID + " = ?";
        String[] whereArgs = new String[]{Integer.toString(id)};
        database.update(NotesContract.NotesEntry.TABLE_NAME,contentValues,where,whereArgs);
        Toast.makeText(this, "Заметка отредактирована!", Toast.LENGTH_SHORT).show();
        finish();
    }
    public void closeEditNote(View v) {
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
