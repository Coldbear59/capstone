package company.co.kr.chaeum1.Control;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import company.co.kr.chaeum1.R;

import static company.co.kr.chaeum1.R.id.week_spinner_dropdown;

/**
 * Created by LEE on 2017-04-07.
 */

public class WizardFragment extends Fragment {

    int wizard_page_position;

    public WizardFragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.timeset;
        switch (wizard_page_position) {
            case 0:
                layout_id = R.layout.timeset;
                break;

            case 1:
                layout_id = R.layout.locationset;
                break;
        }

        View v1 = inflater.inflate(R.layout.timeset, container, false);
        View v2 = inflater.inflate(R.layout.locationset, container, false);

        CurrentTime currenttime = new CurrentTime();

        //호관 선택을 위한 컨텍스트 받아오기
        final WizardFragment cont = this;

        //스피너 목록 집어넣기
        Spinner week_spinner = (Spinner) v1.findViewById(week_spinner_dropdown);
        ArrayAdapter<CharSequence> week_adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.week_array, android.R.layout.simple_spinner_item);
        week_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        week_spinner.setAdapter(week_adapter);
        //현재 요일 첫선택으로
        week_spinner.setSelection(currenttime.doDayOfWeek());

        //시간 스피너
        Spinner time_spinner = (Spinner) v1.findViewById(R.id.time_spinner);
        ArrayAdapter<CharSequence> time_adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.time_array, android.R.layout.simple_spinner_item);
        time_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time_spinner.setAdapter(time_adapter);
        //현재 시간 첫선택으로
        time_spinner.setSelection(currenttime.doCurrentTime());

        //장소 스피너
        Spinner location_spinner = (Spinner) v2.findViewById(R.id.location_spinner);
        final ArrayAdapter<CharSequence> location_adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.location_array, android.R.layout.simple_spinner_item);
        location_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location_spinner.setAdapter(location_adapter);


        //호관 스피너
        final Spinner number_spinner = (Spinner) v2.findViewById(R.id.number_spinner);


        //선택시 실행 과정
        week_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //시간 선택 스피너
        time_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //장소 선택 스피너
        location_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);

                switch(position){
                    case 1:
                        final ArrayAdapter<CharSequence> number0_adapter = ArrayAdapter.createFromResource(cont.getActivity(), R.array.engineer_number_array, android.R.layout.simple_spinner_item);
                        number0_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        number_spinner.setAdapter(number0_adapter);
                        break;

                    case 2:
                        final ArrayAdapter<CharSequence> number1_adapter = ArrayAdapter.createFromResource(cont.getActivity(), R.array.human_number_array, android.R.layout.simple_spinner_item);
                        number1_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        number_spinner.setAdapter(number1_adapter);
                        break;

                    case 3:
                        final ArrayAdapter<CharSequence> number2_adapter = ArrayAdapter.createFromResource(cont.getActivity(), R.array.society_number_array, android.R.layout.simple_spinner_item);
                        number2_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        number_spinner.setAdapter(number2_adapter);
                        break;

                    default:
                        final ArrayAdapter<CharSequence> number3_adapter = ArrayAdapter.createFromResource(cont.getActivity(), R.array.reminder_number_array, android.R.layout.simple_spinner_item);
                        number3_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        number_spinner.setAdapter(number3_adapter);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //시간 선택 스피너
        number_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        if(wizard_page_position == 0) {
            return v1;
        }
        else
            return v2;
    }
}
