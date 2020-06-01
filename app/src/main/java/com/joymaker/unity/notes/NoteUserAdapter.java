package com.joymaker.unity.notes;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.joymaker.unity.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteUserAdapter extends RecyclerView.Adapter<NoteUserAdapter.NotesViewHolder> {
private ArrayList<Note> notes;
private OnDeleteItemClickListener onDeleteItemClickListener;
private OnEditItemClickListener onEditItemClickListener;

    public void setOnEditItemClickListener(OnEditItemClickListener onEditItemClickListener) {
        this.onEditItemClickListener = onEditItemClickListener;
    }

    public NoteUserAdapter(ArrayList<Note> notes) {
        this.notes = notes;
        }
    public void setOnDeleteItemClickListener(OnDeleteItemClickListener onDeleteItemClickListener) {
        this.onDeleteItemClickListener = onDeleteItemClickListener;
    }

    interface OnEditItemClickListener {
        void onEditItem(int position);
    }

 interface OnDeleteItemClickListener {
        void onDeleteItem(int position);
    }
@NonNull
@Override
public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_user_item, parent, false);
        return new NotesViewHolder(v);
        }



    @Override
public void onBindViewHolder(@NonNull NotesViewHolder holder, final int position) {
        Note note = notes.get(position);
        holder.textViewTitle.setText(note.getTitle());
        holder.textViewText.setText(note.getText());

        }

@Override
public int getItemCount() {
        return notes.size();
        }

class NotesViewHolder extends RecyclerView.ViewHolder implements PopupMenu.OnMenuItemClickListener {
    private TextView textViewTitle;
    private TextView textViewText;
    private ImageButton imageBtn;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        textViewText = itemView.findViewById(R.id.textViewText);
        imageBtn = itemView.findViewById(R.id.imageButton2);
        imageBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(v.getContext(), v);
                popup.inflate(R.menu.my_menu);
                popup.setOnMenuItemClickListener(NotesViewHolder.this);
                popup.show();
            }
        });



    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.del:
            if(onDeleteItemClickListener != null) {
                onDeleteItemClickListener.onDeleteItem(getAdapterPosition());
            }
            break;
            case R.id.editText:
                if (onEditItemClickListener != null) {
                    onEditItemClickListener.onEditItem(getAdapterPosition());
                }
        }
        return false;
    }
}
}
