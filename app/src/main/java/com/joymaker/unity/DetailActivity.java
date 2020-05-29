package com.joymaker.unity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {
    private WebView detailWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acitvity);
        detailWebView = findViewById(R.id.detailWebView);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WebSettings settings = detailWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        int index = intent.getIntExtra("unity",-1);
        switch (index) {
            case 1:
                detailWebView.loadUrl("file:///android_asset/camera.html");
                setTitle("Камера");
                break;
            case 2:
                detailWebView.loadUrl("file:///android_asset/light.html");
                setTitle("Освещение");
                break;
            case 3:
                detailWebView.loadUrl("file:///android_asset/prefab.html");
                setTitle("Prefab");
                break;
            case 4:
                detailWebView.loadUrl("file:///android_asset/scenes.html");
                setTitle("Сцены");
                break;
            case 5:
                detailWebView.loadUrl("file:///android_asset/unitypackage.html");
                setTitle("Упаковка проекта в Unity Package File");
                break;
            case 6:
                detailWebView.loadUrl("file:///android_asset/tags.html");
                setTitle("Теги");
                break;

            case 25:
                detailWebView.loadUrl("file:///android_asset/hk.html");
                setTitle("Горячие клавиши");
                break;

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
