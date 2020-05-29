package com.joymaker.unity;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    ListView mainListView;
    FloatingActionButton flb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_root, container, false);
        mainListView = v.findViewById(R.id.mainListView);
        flb = v.findViewById(R.id.floatingActionButton);
        flb.setImageResource(R.drawable.keys);
        String[] l = {"Интерфейс Unity",
                      "Камера",
                      "Освещение",
                      "Prefab",
                      "Сцены",
                      "Упаковка проекта в Unity Package File",
                     "Теги",
                      "Компоненты",
                      "UI",
                      "Скрипты в Unity"

        };
        ArrayAdapter<String> s = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,l);
        mainListView.setAdapter(s);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent (getContext(), InterfaceUnityActivity.class);
                        intent.putExtra("unity",position);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent (getContext(), DetailActivity.class);
                        intent.putExtra("unity",position);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent (getContext(), DetailActivity.class);
                        intent.putExtra("unity",position);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent (getContext(), DetailActivity.class);
                        intent.putExtra("unity",position);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent (getContext(), DetailActivity.class);
                        intent.putExtra("unity",position);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent (getContext(), DetailActivity.class);
                        intent.putExtra("unity",position);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent (getContext(), DetailActivity.class);
                        intent.putExtra("unity",position);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent (getContext(), ComponentsActivity.class);
                        intent.putExtra("unity",position);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent (getContext(), UiActivity.class);
                        intent.putExtra("unity",position);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent (getContext(), ScriptsActivity.class);
                        intent.putExtra("unity",position);
                        startActivity(intent);
                        break;
                }
            }
        });
        flb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),DetailActivity.class);
                intent.putExtra("unity",25);
                startActivity(intent);
            }
        });
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
