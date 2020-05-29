package com.joymaker.unity.unityUI;

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

public class UiActivity extends AppCompatActivity {
        private ListView uiListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        setTitle("UI");
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        uiListView = findViewById(R.id.uiListView);
        String[] ui = {"Canvas","Event System","Panel","Text","Image и Raw Image","Button","Toggle","Slider","Dropdown","Input Field", "Scrollbar", "Scroll View"};
        ArrayAdapter<String> uiAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,ui);
        uiListView.setAdapter(uiAdapter);
        uiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent (getApplicationContext(), DetailUiActivity.class);
                        intent.putExtra("ui",position);
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
