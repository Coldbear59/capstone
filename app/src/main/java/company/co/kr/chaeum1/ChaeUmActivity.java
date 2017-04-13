package company.co.kr.chaeum1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChaeUmActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void myListener(View target) {
        Intent intent = new Intent(getApplicationContext(), SlidingActivity.class);
        startActivity(intent);
    }

    public void StudyListener(View target) {
        Intent intent = new Intent(getApplicationContext(),FaceBookLogin.class);
        startActivity(intent);
    }
}
