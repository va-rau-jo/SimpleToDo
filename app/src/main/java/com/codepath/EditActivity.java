package com.codepath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static com.codepath.MainActivity.ITEM_POSITION;
import static com.codepath.MainActivity.ITEM_TEXT;

public class EditActivity extends AppCompatActivity {

    private EditText etItemText;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItemText = findViewById(R.id.etEditItem);
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        getSupportActionBar().setTitle("Edit Item");
    }

    public void onSaveItem(View v) {
        Intent data = new Intent();
        data.putExtra(ITEM_TEXT, etItemText.getText().toString());
        data.putExtra(ITEM_POSITION, position);
        setResult(RESULT_OK, data);
        hideKeyboard();
        finish();
    }

    // hide the keyboard after hitting the save button
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = this.getCurrentFocus();

        if (view == null) {
            view = new View(this);
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
