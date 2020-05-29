package com.joymaker.unity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DetailUiActivity extends AppCompatActivity {
        private WebView uiWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ui);
        uiWebView = findViewById(R.id.uiWebView);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WebSettings settings = uiWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        int index = intent.getIntExtra("ui",-1);
        switch (index) {
            case 0:
                uiWebView.loadUrl("file:///android_asset/UI/canvas.html");
                setTitle("Canvas");
                break;
            case 1:
                uiWebView.loadUrl("file:///android_asset/UI/eventsystem.html");
                setTitle("Event System");
                break;
            case 2:
                uiWebView.loadUrl("file:///android_asset/UI/panel.html");
                setTitle("Panel");
                break;
            case 3:
                uiWebView.loadUrl("file:///android_asset/UI/text.html");
                setTitle("Text");
                break;
            case 4:
                uiWebView.loadUrl("file:///android_asset/UI/image.html");
                setTitle("Image и Raw Image");
                break;
            case 5:
                uiWebView.loadUrl("file:///android_asset/UI/button.html");
                setTitle("Button");
                break;
            case 6:
                uiWebView.loadUrl("file:///android_asset/UI/toggle.html");
                setTitle("Toggle");
                break;
            case 7:
                uiWebView.loadUrl("file:///android_asset/UI/slider.html");
                setTitle("Slider");
                break;
            case 8:
                uiWebView.loadUrl("file:///android_asset/UI/dropdown.html");
                setTitle("Dropdown");
                break;
            case 9:
                uiWebView.loadUrl("file:///android_asset/UI/inputfield.html");
                setTitle("Input Field");
                break;
            case 10:
                uiWebView.loadUrl("file:///android_asset/UI/scrollbar.html");
                setTitle("Scrollbar");
                break;
            case 11:
                uiWebView.loadUrl("file:///android_asset/UI/scrollview.html");
                setTitle("Scroll View");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this,UiActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
