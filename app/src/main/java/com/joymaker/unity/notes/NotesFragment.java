package com.joymaker.unity.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private  RecyclerView recyclerViewNotes;
    private ArrayList<Note> notes = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
         String[] nameNotes = getResources().getStringArray(R.array.nameNotes);
         String[] notesArray = getResources().getStringArray(R.array.notes);

        v = inflater.inflate(R.layout.fragment_notes, container, false);
        recyclerViewNotes = v.findViewById(R.id.recyclerViewNotes);
        for (int i = 0; i < nameNotes.length; i++) {
            notes.add(new Note(nameNotes[i],notesArray[i]));
        }
        NotesAdapter adapter = new NotesAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewNotes.setAdapter(adapter);
        return v;
    }
}
