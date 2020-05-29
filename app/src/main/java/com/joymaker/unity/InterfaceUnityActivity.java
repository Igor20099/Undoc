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

public class InterfaceUnityActivity extends AppCompatActivity {
    private ListView interfaceUnityListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_unity);
        setTitle("Интерфейс Unity");
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        interfaceUnityListView = findViewById(R.id.interfaceUnityList);
        String[] interfaceUnityList = {"Окно иерархии", "Окно сцены", "Окно инструментов", "Окно игры", "Окно инспектора", "Окно проекта",
                "Консоль", "Окно анимации","Окно аниматора", "Расположение окон"};
        ArrayAdapter<String> interUnityAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,interfaceUnityList);
        interfaceUnityListView.setAdapter(interUnityAdapter);
        interfaceUnityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent (getApplicationContext(), DetailInterfaceUnityActivity.class);
                        intent.putExtra("inter",position);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent (getApplicationContext(), DetailInterfaceUnityActivity.class);
                        intent.putExtra("inter",position);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent (getApplicationContext(), DetailInterfaceUnityActivity.class);
                        intent.putExtra("inter",position);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent (getApplicationContext(), DetailInterfaceUnityActivity.class);
                        intent.putExtra("inter",position);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent (getApplicationContext(), DetailInterfaceUnityActivity.class);
                        intent.putExtra("inter",position);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent (getApplicationContext(), DetailInterfaceUnityActivity.class);
                        intent.putExtra("inter",position);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent (getApplicationContext(), DetailInterfaceUnityActivity.class);
                        intent.putExtra("inter",position);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent (getApplicationContext(), DetailInterfaceUnityActivity.class);
                        intent.putExtra("inter",position);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent (getApplicationContext(), DetailInterfaceUnityActivity.class);
                        intent.putExtra("inter",position);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent (getApplicationContext(), DetailInterfaceUnityActivity.class);
                        intent.putExtra("inter",position);
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
