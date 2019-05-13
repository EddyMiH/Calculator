package com.example.eddy.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String displayValue;
    private double ans;
    private EditText display;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display_editText_main_activity);
        ClearAns();
        upDateDisplay();

        findViewById(R.id.btn_clear_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearAns();
                flag = false;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_zero_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += "0";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_one_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += "1";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_two_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += "2";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_three_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += "3";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_four_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += "4";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_five_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += "5";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_six_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += "6";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_seven_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += "7";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_eight_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += "8";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_nine_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += "9";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_dot_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue += ".";
                flag = true;
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_plus_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    displayValue += "+";
                    flag = false;
                }
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_minus_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    displayValue += "-";
                    flag = false;
                }

                upDateDisplay();
            }
        });
        findViewById(R.id.btn_mult_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    displayValue += "*";
                    flag = false;
                }
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_divide_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    displayValue += "/";
                    flag = false;
                }
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_equal_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countAnswer();
                //displayValue = Double.toString(ans);
                upDateDisplay();
            }
        });
        findViewById(R.id.btn_percent_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag)
                    displayValue += "/100";
                //flag = true;
                upDateDisplay();
            }
        });

    }
    public void ClearAns(){
        displayValue = "";
        //display.setHint("0");
        //display.setHint();
        ans = 0;
    }
    public void upDateDisplay(){

        display.setText(displayValue);
    }

    public void countAnswer() {
        //String displayValue = "5+1*2-2+8/2";
        ArrayList<Double> S_num = new ArrayList<>();
        ArrayList<String> Operation = new ArrayList<>();
        char[] ch = displayValue.toCharArray();
        String num = "";
        for (int i = 0; i < ch.length; i++) {
            if ((ch[i] >= '0' && ch[i] <= '9') || ch[i] == '.') {
                num += String.valueOf(ch[i]);
            } else {
                try{
                    S_num.add(Double.parseDouble(num));
                }catch (Exception ex){
                    ClearAns();
                    displayValue= "error";
                    upDateDisplay();
                    return;
                }

                Operation.add(String.valueOf(ch[i]));
                num = "";
            }
            if (i == ch.length - 1) {
                try{
                    S_num.add(Double.parseDouble(num));
                }catch (NumberFormatException e){
                    ClearAns();
                    displayValue= "error";
                    upDateDisplay();
                    return;
                }

            }
        }
        for (int i = 0; i < Operation.size(); i++) {
            double res;
            if (Operation.get(i).equals("*")) {
                res = S_num.get(i) * S_num.get(i + 1);

                S_num.set(i, res);
                S_num.remove(i + 1);
                Operation.remove(i);
                i--;
            } else if (Operation.get(i).equals("/")) {
                res = S_num.get(i) / S_num.get(i + 1);

                S_num.set(i, res);
                S_num.remove(i + 1);
                Operation.remove(i);
                i--;
            }
        }
        for (int i = 0; i < Operation.size(); i++) {
            double res;
            if (Operation.get(i).equals("+")) {
                res = S_num.get(i) + S_num.get(i + 1);

                S_num.set(i, res);
                S_num.remove(i + 1);
                Operation.remove(i);
                i--;
            } else if (Operation.get(i).equals("-")) {
                try{
                    res = S_num.get(i) - S_num.get(i + 1);
                }catch (Exception ex){
                    ClearAns();
                    displayValue= "error";
                    upDateDisplay();
                    return;
                }

                Log.d(MainActivity.class.getName(),"Size of operation: " + String.valueOf(Operation.size()));

                S_num.set(i, res);
                S_num.remove(i + 1);
                Operation.remove(i);
                i--;
            }
        }
        try{
            ans = S_num.get(0);
        }catch (IndexOutOfBoundsException ex){
            ClearAns();
        }
        displayValue = Double.toString(ans);
        //Log.d(MainActivity.class.getName(),"Size: " + String.valueOf(S_num.size()));
        //Log.d(MainActivity.class.getName(),String.valueOf(S_num.get(0)));
        //Log.d(MainActivity.class.getName(),String.valueOf(ans));
        //Log.d(MainActivity.class.getName(),displayValue);
        S_num.clear();
    }
}
