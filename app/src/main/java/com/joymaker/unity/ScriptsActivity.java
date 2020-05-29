package com.joymaker.unity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ScriptsActivity extends AppCompatActivity {
    private ListView scriptsListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scripts);
        setTitle("Скрипты в Unity");
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        scriptsListView = findViewById(R.id.scriptsListView);
        String[] scripts = {"Скрипты","Типы данных","Атрибуты", "Методы Awake,Start,Update,FixedUpdate,LateUpdate","Метод GetComponent", "Методы Instantiate и Destroy", "Класс Transform",
        "Класс Rigidbody", "Класс Animator","Обработка столкновений","Корутины"};
        ArrayAdapter<String> scriptAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,scripts);
        scriptsListView.setAdapter(scriptAdapter);
        scriptsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch(position) {
                    case 0:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent (getApplicationContext(), DetailScriptsActivity.class);
                        intent.putExtra("script",position);
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
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
