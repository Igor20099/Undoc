package com.joymaker.unity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DetailsComponentsActivity extends AppCompatActivity {
    private WebView componentWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_components);
        componentWebView = findViewById(R.id.componentWebView);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WebSettings settings = componentWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        int index = intent.getIntExtra("comp",-1);
        switch (index) {
            case 0:
                componentWebView.loadUrl("file:///android_asset/components/component.html");
                setTitle("Компонент");
                break;
            case 1:
                componentWebView.loadUrl("file:///android_asset/components/transform.html");
                setTitle("Transform");
                break;
            case 2:
                componentWebView.loadUrl("file:///android_asset/components/recttransform.html");
                setTitle("Rect Transform");
                break;
            case 3:
                componentWebView.loadUrl("file:///android_asset/components/colliders.html");
                setTitle("Коллайдеры");
                break;
            case 4:
                componentWebView.loadUrl("file:///android_asset/components/rigidbody.html");
                setTitle("Rigidbody");
                break;
            case 5:
                componentWebView.loadUrl("file:///android_asset/components/meshrender.html");
                setTitle("Mesh Filter и Mesh Render");
                break;
            case 6:
                componentWebView.loadUrl("file:///android_asset/components/spriterender.html");
                setTitle("Sprite Render");
                break;
            case 7:
                componentWebView.loadUrl("file:///android_asset/components/joints.html");
                setTitle("Joints(соединение объектов)");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this,ComponentsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
