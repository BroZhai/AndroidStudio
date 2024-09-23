package comp4342.android.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HelloAndroid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}