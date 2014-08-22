package com.example.learnhtml;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	Button click;
	EditText edit;
	WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		click = (Button) findViewById(R.id.button1);
		edit = (EditText) findViewById(R.id.editText1);
		webview = (WebView) findViewById(R.id.webView1);

		click.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final String view = edit.getText().toString();

				webview.loadData(view, "text/html", "utf-8");
				webview.getSettings().setRenderPriority(RenderPriority.HIGH);
				webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
				webview.getSettings().setJavaScriptEnabled(true);
				webview.getSettings().setBuiltInZoomControls(true);
				webview.requestFocusFromTouch();
				webview.setWebViewClient(new WebViewClient());
				webview.setWebChromeClient(new WebChromeClient());

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
