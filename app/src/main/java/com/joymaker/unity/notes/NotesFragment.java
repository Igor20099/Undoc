package com.joymaker.unity.notes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;
import android.widget.Toolbar;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.joymaker.unity.CreateNote;
import com.joymaker.unity.EditNote;
import com.joymaker.unity.NotesContract;
import com.joymaker.unity.NotesDBHelper;
import com.joymaker.unity.R;
import com.joymaker.unity.notes.Note;
import com.joymaker.unity.notes.NotesAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NotesFragment extends Fragment {
    private NotesDBHelper dbHelper;
    private  RecyclerView recyclerViewNotes;
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<Note> notesFromDB = new ArrayList<>();

    private FloatingActionsMenu menu;
    private FloatingActionButton createNote;
    private FloatingActionButton myNotes;
    private FloatingActionButton standartNotes;
    SQLiteDatabase database;
    NotesAdapter adapter;
    String[] nameNotes;
    String[] notesArray;

    private NoteUserAdapter notesAdapterDB;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
         nameNotes = getResources().getStringArray(R.array.nameNotes);
          notesArray = getResources().getStringArray(R.array.notes);

        v = inflater.inflate(R.layout.fragment_notes, container, false);
        recyclerViewNotes = v.findViewById(R.id.recyclerViewNotes);
        createNote = v.findViewById(R.id.createNote);
        myNotes = v.findViewById(R.id.myNotes);
        standartNotes = v.findViewById(R.id.notes);
        createNote.setColorFilter(Color.argb(255,255,255,255));
        myNotes.setColorFilter(Color.argb(255,255,255,255));
        standartNotes.setColorFilter(Color.argb(255,255,255,255));
        menu = v.findViewById(R.id.floatmenu);
        for (int i = 0; i < nameNotes.length; i++) {
            notes.add(new Note(0,nameNotes[i],notesArray[i]));
        }

         adapter = new NotesAdapter(notes);
        adapter.notifyDataSetChanged();
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewNotes.setAdapter(adapter);
        dbHelper = new NotesDBHelper(getContext());
        database = dbHelper.getReadableDatabase();
        notesAdapterDB = new NoteUserAdapter(notesFromDB);

        notesAdapterDB.setOnEditItemClickListener(new NoteUserAdapter.OnEditItemClickListener() {
            @Override
            public void onEditItem(int position) {
                int id = notesFromDB.get(position).getId();
               // Toast.makeText(getContext(), "" + id, Toast.LENGTH_SHORT).show();
                Cursor cursor = database.query(NotesContract.NotesEntry.TABLE_NAME,null,null,null,null,null,null);
                cursor.moveToPosition(position);
                String title = cursor.getString(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_TITLE));
                String description = cursor.getString(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_DESCRIPTION));
                cursor.close();
                Intent intent = new Intent(getContext(), EditNote.class);
                intent.putExtra("id",id);
                intent.putExtra("title",title);
                intent.putExtra("desc",description);
                startActivity(intent);
            }
        });



   //Удаление заметки из списка и базы данных
        notesAdapterDB.setOnDeleteItemClickListener(new NoteUserAdapter.OnDeleteItemClickListener() {
            @Override
            public void onDeleteItem(int position) {
                int id = notesFromDB.get(position).getId();
                Toast.makeText(getContext(), "Заметка удалена!", Toast.LENGTH_SHORT).show();
                String where = NotesContract.NotesEntry._ID + " = ?";
                String[] whereArgs = new String[]{Integer.toString(id)};
                database.delete(NotesContract.NotesEntry.TABLE_NAME,where,whereArgs);
                notesFromDB.clear();
                getData();
                notesAdapterDB.notifyDataSetChanged();
            }
        });


        createNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CreateNote.class);
                menu.collapse();
                startActivity(intent);
            }
        });


        myNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.collapse();
                notesFromDB.clear();
                notesAdapterDB.notifyDataSetChanged();
                notes.clear();
                adapter.notifyDataSetChanged();
                getData();
                notesAdapterDB.notifyDataSetChanged();
                recyclerViewNotes.setAdapter(notesAdapterDB);
            }
        });
        standartNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.collapse();
                notesFromDB.clear();
                notes.clear();
                adapter.notifyDataSetChanged();
                String[] nameNotes = getResources().getStringArray(R.array.nameNotes);
                String[] notesArray = getResources().getStringArray(R.array.notes);
                for (int i = 0; i < nameNotes.length; i++) {
                    notes.add(new Note(0,nameNotes[i],notesArray[i]));
                }
                adapter.notifyDataSetChanged();
                recyclerViewNotes.setAdapter(adapter);
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        menu.collapse();
        notesFromDB.clear();
        notesAdapterDB.notifyDataSetChanged();
        notes.clear();
        adapter.notifyDataSetChanged();

            Cursor cursor = database.query(NotesContract.NotesEntry.TABLE_NAME, null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex(NotesContract.NotesEntry._ID));
                String title = cursor.getString(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_TITLE));
                String description = cursor.getString(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_DESCRIPTION));
                Note note = new Note(id, title, description);
                notesFromDB.add(note);
            }
            cursor.close();

            notesAdapterDB.notifyDataSetChanged();
            if(!notesFromDB.isEmpty()) {
                recyclerViewNotes.setAdapter(notesAdapterDB);
            } else {
                //database.delete("SQLITE_SEQUENCE","NAME=?",new String[]{NotesContract.NotesEntry.TABLE_NAME});
                for (int i = 0; i < nameNotes.length; i++) {
                    notes.add(new Note(0,nameNotes[i],notesArray[i]));
                }

                adapter.notifyDataSetChanged();
                recyclerViewNotes.setAdapter(adapter);
            }


    }

    public void getData(){
        Cursor cursor = database.query(NotesContract.NotesEntry.TABLE_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(NotesContract.NotesEntry._ID));
            String title = cursor.getString(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_TITLE));
            String description = cursor.getString(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_DESCRIPTION));
            Note note = new Note(id,title,description);
            notesFromDB.add(note);
        }
        cursor.close();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        database.close();
    }
}
