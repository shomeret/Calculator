package com.example.week2project;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int op1 = 0, op2 = 0, total = 0, dv1 = 0, dv2 = 0, dvTot = 0, mp1=0, mp2=0, mpTot = 0;
    List<String> arr = new ArrayList<>();
    List<String> historyArr = new ArrayList<>();

    public void addHistory(String val) {
        historyArr.add(val);

    }

    public List<String> showHistory() {
        return historyArr;
    }

    public void clearStr() {
        arr.clear();
    }
    public List<String> getStr() {
        return arr;
    }
    public void push(String val) {
        arr.add(val);
    }

    public int calculate() {
        int arrSize = arr.size();
        int flagSymbol = 0;
        int flagSymbolCnt = 0;
        for (int i = 1; i < arrSize - 1; i += 2) {
            flagSymbol = flagSymbol + 1;
            if (arr.get(i) == "+" || arr.get(i) == "-" || arr.get(i) == "*" || arr.get(i) == "/") {
                flagSymbolCnt = flagSymbolCnt + 1;
            }
        }

        if (flagSymbolCnt == flagSymbol) {
            /// CODE FOR DOING DIVISION FIRST
            for (int i = arrSize - 1; i >= 0; i -= 1) {
                if (arr.get(i) == "/") {
                    if (i+1 <= arrSize-1) {
                        dv1 = Integer.parseInt(arr.get(i-1));
                        dv2 = Integer.parseInt(arr.get(i+1));
                        if (dv2 == 0)  {
                            return 100021;   /// EXIT CODE FOR 0 DIVISON
                        } else {
                            dvTot = dv1 / dv2;
                            String dvStr = Integer.toString(dvTot);
                            arr.set(i - 1, dvStr);
                            if (i + 2 <= arrSize - 1) {
                                if (arr.get(i + 2) == "*") {
                                    arr.set(i + 1, "1");
                                }
                            } else
                                arr.set(i + 1, "0");
                        }
                        arr.set(i, "+");
                    }
                }
            }

                // CODE FOR MULTIPLICATION
            for (int i = arrSize - 1; i >= 0; i -= 1) {
                if (arr.get(i) == "*") {
                    if (i+1 <= arrSize-1) {
                        mp1 = Integer.parseInt(arr.get(i-1));
                        mp2 = Integer.parseInt(arr.get(i+1));

                        mpTot = mp1 * mp2;
                        String mpStr = Integer.toString(mpTot);
                        arr.set(i - 1, mpStr);
                        arr.set(i + 1, "0");
                        arr.set(i, "+");
                    }
                }
            }


            for (int i = 0; i <= arrSize - 1; i += 2) {
                if (i==0) {
                    op1 = Integer.parseInt(arr.get(i));
                } else {
                    op1 = total;
                }

                if (i + 2 <= arrSize - 1) {
                    op2 = Integer.parseInt(arr.get(i + 2));
                }



                if (i <= arrSize - 2) {
                    if (arr.get(i + 1) == "+") {
                        total = op1 + op2;
                        op2 = 0;
                    } else if (arr.get(i + 1) == "-") {
                        total = op1 - op2;
                        op2 = 0;
                    }
                }

            }
            return total;
        } else {
            return 9871;  // EXUT CODE FOR MORE THAN SINGLE DIGIT INT
        }


    }
}
