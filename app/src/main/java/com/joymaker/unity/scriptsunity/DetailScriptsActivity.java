package com.joymaker.unity.scriptsunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.joymaker.unity.R;
import com.joymaker.unity.scriptsunity.ScriptsActivity;

public class DetailScriptsActivity extends AppCompatActivity {
 private WebView scriptWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_scripts);
        scriptWebView = findViewById(R.id.scriptWebView);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WebSettings settings = scriptWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        int index = intent.getIntExtra("script",-1);
        switch (index) {
            case 0:
                scriptWebView.loadUrl("file:///android_asset/scripts/script.html");
                setTitle("Скрипты");
                break;
            case 1:
                scriptWebView.loadUrl("file:///android_asset/scripts/datatype.html");
                setTitle("Типы данных");
                break;
            case 2:
                scriptWebView.loadUrl("file:///android_asset/scripts/attributes.html");
                setTitle("Атрибуты");
                break;
            case 3:
                scriptWebView.loadUrl("file:///android_asset/scripts/methodstartupdate.html");
                setTitle("Методы Awake,Start,Update,FixedUpdate,LateUpdate");
                break;
            case 4:
                scriptWebView.loadUrl("file:///android_asset/scripts/getcomponent.html");
                setTitle("Метод GetComponent");
                break;
            case 5:
                scriptWebView.loadUrl("file:///android_asset/scripts/instantiate.html");
                setTitle("Методы Instantiate и Destroy");
                break;
            case 6:
                scriptWebView.loadUrl("file:///android_asset/scripts/classtransform.html");
                setTitle("Класс Transform");
                break;
            case 7:
                scriptWebView.loadUrl("file:///android_asset/scripts/classrigidbody.html");
                setTitle( "Класс Rigidbody");
                break;
            case 8:
                scriptWebView.loadUrl("file:///android_asset/scripts/classanimator.html");
                setTitle("Класс Animator");
                break;
            case 9:
                scriptWebView.loadUrl("file:///android_asset/scripts/collider.html");
                setTitle("Обработка столкновений");
                break;
            case 10:
                scriptWebView.loadUrl("file:///android_asset/scripts/corutine.html");
                setTitle("Корутины");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, ScriptsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
