package company.co.kr.chaeum1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by LEE on 2017-04-01.
 * 빈강의실 시간 설정 하는 화면
 * 해야 할 것 : 시간 설정한 거 변수로 받기
 */

public class timesetLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeset);

        Spinner week_spinner = (Spinner) findViewById(R.id.week_spinner);
        ArrayAdapter<CharSequence> week_adapter = ArrayAdapter.createFromResource(this, R.array.week_array, android.R.layout.simple_spinner_item);
        week_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        week_spinner.setAdapter(week_adapter);

        Spinner time_spinner = (Spinner) findViewById(R.id.time_spinner);
        ArrayAdapter<CharSequence> time_adapter = ArrayAdapter.createFromResource(this, R.array.time_array, android.R.layout.simple_spinner_item);
        time_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time_spinner.setAdapter(time_adapter);

        week_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        time_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
