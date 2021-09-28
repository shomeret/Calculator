package com.example.week2project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Calculator calculate;
    String tag = "Assignment 1";
    TextView screen;
    String calc= "";
    ArrayList<String> str = new ArrayList<String>();
    Float ntmp1, ntmp2;
    Boolean addition, subtraction, multiplication, division;
    Button OneB, TwoB, ThreeB, FourB, FiveB, SixB, SevenB, EightB, NineB, ZeroB, PlusB, MinusB, DivideB, MultipB, ClearB, AdvanceB, EqualB;
    TextView screenHistory;
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(tag,"in OnCreate");
        setContentView(R.layout.activity_main);

        calculate = new Calculator();
        screenHistory = (TextView) findViewById(R.id.txtHistory);

        /*num1Text = (EditText) findViewById(R.id.num1);
        num2Text = (EditText) findViewById(R.id.num2);*/

        screen = (TextView) findViewById(R.id.edtTxt);
        /// <<< NUMBERED BUTTONS >>>

        ZeroB = (Button) findViewById(R.id.bZero);
        OneB = (Button) findViewById(R.id.bOne);
        TwoB = (Button) findViewById(R.id.bTwo);
        ThreeB = (Button) findViewById(R.id.bThree);
        FourB = (Button) findViewById(R.id.bFour);
        FiveB = (Button) findViewById(R.id.bFive);
        SixB = (Button) findViewById(R.id.bSix);
        SevenB = (Button) findViewById(R.id.bSeven);
        EightB = (Button) findViewById(R.id.bEight);
        NineB = (Button) findViewById(R.id.bNine);


        // <<<<<< ----- SPECIALTY BUTTONS ------- >>>>>>>>>
        MinusB = (Button) findViewById(R.id.bMinus);
        PlusB = (Button) findViewById(R.id.bPlus);
        DivideB = (Button) findViewById(R.id.bDivide);
        MultipB = (Button) findViewById(R.id.bMultip);
        ClearB = (Button) findViewById(R.id.bClear);
        EqualB = (Button) findViewById(R.id.bEqual);
        AdvanceB = (Button) findViewById(R.id.bAdvanced);

        MinusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "-";
                calculate.push("-");
                screen.setText(calc);
                /*calc = calc + "-";
                if (!moreThanOneDigit())
                    screen.setText(calc);
                else
                    screen.setText("");*/
            }
        });


        PlusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*calc = calc + "+";
                Log.v(TAG, "calc is" + calc);
                if (!moreThanOneDigit())
                    screen.setText(calc);
                else
                    screen.setText("0");*/
                calc = calc + "+";
                calculate.push("+");
                screen.setText(calc);
            }
        });

        DivideB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "/";
                calculate.push("/");
                screen.setText(calc);
            }
        });

        MultipB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "*";
                calculate.push("*");
                screen.setText(calc);
            }
        });


        EqualB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tot = calculate.calculate();

                if (tot == 100021) {
                    screen.setText("Division By 0 not allowed. Press 'C'.");
                } else if (tot == 9871) {
                    screen.setText("Only use single digits. Press 'C'.");
                } else {
                    String totSt = Integer.toString(tot);
                    //List<String> totalStr = calculate.getStr();
                /*String joined = TextUtils.join(", ", totalStr);
                String finalSt = (joined + " = " + totSt);*/
                    String finalSt = calc + " = " + totSt;
                    Log.v(TAG, "The joined string is " + finalSt);
                    calculate.addHistory(finalSt);
                    screen.setText(finalSt);
                }


/*
                calc = calc + "=";
                Log.v(TAG, "calc in equal is" + calc);
                char[] charArr = new char[calc.length()];
                double tmp = 0.0, total = 0.0, tmp2 = 0.0;
                String finTot = "";

                if (!moreThanOneDigit()) {
                    for (int i = 0; i < calc.length(); i++) {
                        charArr[i] = calc.charAt(i);
                        Log.v(TAG, "first array=" + charArr[i]);
                    }

                    for (int j = 0; j < calc.length() - 2; j++) {
                        if (charArr[j] == '*') {
                            tmp = ((double) charArr[j - 1] * (double) charArr[j + 1]);
                            charArr[j + 1] = (char)tmp;
                            charArr[j] = '0';
                            charArr[j - 1] = '0';
                        } else if (charArr[j] == '/') {
                            if (charArr[j + 1] == '0') {
                                screen.setText("Cannot divide by 0");
                                calc = "";
                            } else {
                                tmp = ((double) charArr[j - 1] / (double) charArr[j + 1]);
                                charArr[j + 1] = (char)tmp;
                                charArr[j] = '0';
                                charArr[j - 1] = '0';
                            }
                        }
                    }

                    for (int j = 0; j < calc.length() - 2; j++) {
                        if (charArr[j] == '1' |)
                        if (charArr[j+1] == '=') {
                            break;
                        }
                        Log.v(TAG, "index=" + charArr[j]);

                        if (charArr[j] == '0')
                            continue;

                        if (charArr[j] == '+') {
                            Log.v(TAG, "charArr of j+1 is " + charArr[j+1]);
                            total = tmp2 + (double) charArr[j + 1];
                            charArr[j+1] = (char)total;
                            Log.v(TAG, "tmp2 is " + tmp2);
                            Log.v(TAG, "total is " + total);
                        } else if (charArr[j] == '-') {
                            total = tmp2 - (double)charArr[j + 1];
                            charArr[j+1] = (char)total;
                        } else if (charArr[j] != '-' && charArr[j] != '+'){
                            Log.v(TAG, "charArr of J firstTIME is  " + charArr[j]);
                            Log.v(TAG, "firsTime tmp2 is " + tmp2);
                            tmp2 = (double)charArr[j];
                            Log.v(TAG, "firsTime AFTER ASSIGNING tmp2 is " + tmp2);
                        }
                    }


                    finTot = Double.toString(total);
                    //finTot = Character.toString(charArr[0]);
                    screen.setText(finTot);
                } else {
                    calc = "";
                    screen.setText("9099");
                }*/

            }
        });

        ClearB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate.clearStr();
                calc = "";
                screen.setText(calc);
            }
        });

        AdvanceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> tmpList = calculate.showHistory();
                String fullHistory = "";
                for(int i=0; i < tmpList.size(); i++) {
                    fullHistory = fullHistory + tmpList.get(i) + "\n";
                }
                screenHistory.setText(fullHistory);
                AdvanceB.setSelected(!AdvanceB.isSelected());

                if (AdvanceB.isSelected()) {
                    AdvanceB.setText("ADVANCE - WITH HISTORY");
                    screenHistory.setText("");
                } else {
                    AdvanceB.setText("STANDARD - NO HISTORY");
                }
            }
        });
            /// NUMBERED BUTTONS LISTENERS

        ZeroB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "0";
                calculate.push("0");
                screen.setText(calc);

            }
        });

        OneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "1";
                calculate.push("1");
                screen.setText(calc);
            }
        });

        TwoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "2";
                calculate.push("2");
                screen.setText(calc);
            }
        });

        ThreeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "3";
                calculate.push("3");
                screen.setText(calc);
            }
        });

        FourB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "4";
                calculate.push("4");
                screen.setText(calc);
            }
        });


        FiveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "5";
                calculate.push("5");
                screen.setText(calc);
            }
        });

        SixB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "6";
                calculate.push("6");
                screen.setText(calc);
            }
        });

        SevenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "7";
                calculate.push("7");
                screen.setText(calc);
            }
        });

        EightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "8";
                calculate.push("8");
                screen.setText(calc);
            }
        });

        NineB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc = calc + "9";
                calculate.push("9");
                screen.setText(calc);
            }
        });

       /* PlusB = (Button) findViewById(R.id.bPlus);
        PlusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(num1Text.getText().toString() ) + Integer.parseInt(num2Text.getText().toString() );
                Log.d("Result is " , ""+result);
            }
        });*/
    }

    public boolean moreThanOneDigit() {
        int len = calc.length();
        if (calc.length() > 1 && calc.matches("[0-9]+")) {
            calc = "";
            screen.setText("Single digits only, press C");
            return true;
        } else if (calc.length() >= 2 && Character.isDigit(calc.charAt(len-1)) && Character.isDigit(calc.charAt(len-2))) {
            calc = "";
            screen.setText("Single digits only, press C");
            return true;
        } else if (calc.charAt(0) == '+' || calc.charAt(0) == '-' || calc.charAt(0) == '*' || calc.charAt(0) == '/' || calc.charAt(0) == '=') {
            calc = "";
            return true;
        } else
            return false;

    }

    /*private boolean isNumber(String val) {

    }*/

    /*
    private void setCalc(String val) {
        calc = calc + val;
        screen.setText(calc);
    }

    public void clearOnClick(View view) {
        screen.setText("");
        calc = "";


    }
    public void zeroOnClick(View view) {
        if (!moreThanOneDigit()) {
            setCalc("0");
        } else {
            setCalc("0");
        }


    }*/


    /*public void oneOnClick(View view) {
        if (moreThanOneDigit() == false) {
            setCalc("1");
        } else {
            setCalc("0");;
        }
    }

    public void twoOnClick(View view) {
        if (!moreThanOneDigit()) {
            setCalc("2");
        } else {
            clearOnClick(view);
            Log.d("Two is " , ""+ calc);
        }
    }

    public void threeOnClick(View view) {
        if (!moreThanOneDigit()) {
            setCalc("3");
        } else {
            clearOnClick(view);
        }
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag,"in onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag,"in onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag,"in onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag,"in onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag,"in onDestroy");
    }






}