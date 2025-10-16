package site.sunmeat.helloworld;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button1);
        if (b != null) {
            count = b.getInt("key0", 0);
        }
        button.setText(count + "");
        button.setOnClickListener(v -> button.setText(++count + ""));

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle b) {
        super.onSaveInstanceState(b);
        b.putInt("key0", count);
    }


}