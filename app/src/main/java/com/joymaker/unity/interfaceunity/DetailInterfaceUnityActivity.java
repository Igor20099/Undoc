package com.joymaker.unity.interfaceunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.joymaker.unity.R;

public class DetailInterfaceUnityActivity extends AppCompatActivity {
    private WebView detailInterfaceWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_interface_unity);
        detailInterfaceWebView = findViewById(R.id.interfaceWebView);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WebSettings settings = detailInterfaceWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        int index = intent.getIntExtra("inter",-1);
        switch (index) {
            case 0:
                detailInterfaceWebView.loadUrl("file:///android_asset/interfaceunity/hirearhy.html");
                setTitle("Окно иерархии");
                break;
            case 1:
                detailInterfaceWebView.loadUrl("file:///android_asset/interfaceunity/scenewindow.html");
                setTitle("Окно сцены");
                break;
            case 2:
                detailInterfaceWebView.loadUrl("file:///android_asset/interfaceunity/toolbar.html");
                setTitle("Панель инструментов");
                break;
            case 3:
                detailInterfaceWebView.loadUrl("file:///android_asset/interfaceunity/playmode.html");
                setTitle("Окно игры");
                break;
            case 4:
                detailInterfaceWebView.loadUrl("file:///android_asset/interfaceunity/inspector.html");
                setTitle("Окно инспектора");
                break;
            case 5:
                detailInterfaceWebView.loadUrl("file:///android_asset/interfaceunity/project.html");
                setTitle("Окно проекта");
                break;
            case 6:
                detailInterfaceWebView.loadUrl("file:///android_asset/interfaceunity/console.html");
                setTitle("Консоль");
                break;
            case 7:
                detailInterfaceWebView.loadUrl("file:///android_asset/interfaceunity/animation.html");
                setTitle("Окно анимации");
                break;
            case 8:
                detailInterfaceWebView.loadUrl("file:///android_asset/interfaceunity/animator.html");
                setTitle("Окно аниматора");
                break;
            case 9:
                detailInterfaceWebView.loadUrl("file:///android_asset/interfaceunity/layout.html");
                setTitle("Расположение окон");
                break;

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
               Intent intent = new Intent(this, InterfaceUnityActivity.class);
               startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
