package company.co.kr.chaeum1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by LEE on 2017-03-27.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this, ChaeUmActivity.class));
        finish();

    }
}

