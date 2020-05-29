package com.joymaker.unity.components;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.joymaker.unity.MainActivity;
import com.joymaker.unity.R;

public class ComponentsActivity extends AppCompatActivity {
        private ListView componentsListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);

        setTitle("Компоненты");
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        componentsListView = findViewById(R.id.componentsListView);
        String[] components = {"Компонент","Transform", "Rect Transform","Коллайдеры", "Rigidbody", "Mesh Filter и Mesh Render","Sprite Render"};
        ArrayAdapter<String> componentsAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,components);
        componentsListView.setAdapter(componentsAdapter);
        componentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent (getApplicationContext(), DetailsComponentsActivity.class);
                        intent.putExtra("comp",position);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent (getApplicationContext(), DetailsComponentsActivity.class);
                        intent.putExtra("comp",position);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent (getApplicationContext(), DetailsComponentsActivity.class);
                        intent.putExtra("comp",position);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent (getApplicationContext(), DetailsComponentsActivity.class);
                        intent.putExtra("comp",position);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent (getApplicationContext(), DetailsComponentsActivity.class);
                        intent.putExtra("comp",position);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent (getApplicationContext(), DetailsComponentsActivity.class);
                        intent.putExtra("comp",position);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent (getApplicationContext(), DetailsComponentsActivity.class);
                        intent.putExtra("comp",position);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent (getApplicationContext(), DetailsComponentsActivity.class);
                        intent.putExtra("comp",position);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
