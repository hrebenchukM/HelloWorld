package site.sunmeat.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewPalm;
    private Random random = new Random();

    private int totalStrength = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imageViewPalm = findViewById(R.id.imageView2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void f(View view) {
        if (totalStrength < 88) {
            int palmStrength = random.nextInt(20) + 1;

            if (totalStrength + palmStrength > 88) {
                palmStrength = 88 - totalStrength;
            }
            totalStrength += palmStrength;

            float factor = 1 + palmStrength * 0.01f;
            imageViewPalm.setScaleX(imageViewPalm.getScaleX() * factor);
            imageViewPalm.setScaleY(imageViewPalm.getScaleY() * factor);


           // Toast.makeText(this, "+" + palmStrength + " strength to our palm (￣︶￣) ", Toast.LENGTH_SHORT).show();
            Snackbar.make(view, "+" + palmStrength + " palm(s) 🌴", Snackbar.LENGTH_SHORT).show(); //более быстрая шняга
        } else {
            Toast.makeText(this, "🌴 Enough! Stop pouring that water out like a bucket (-_-)", Toast.LENGTH_SHORT).show();
        }
    }
}