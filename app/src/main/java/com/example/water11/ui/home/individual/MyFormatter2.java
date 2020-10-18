package com.example.water11.ui.home.individual;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.AxisValueFormatter;

import java.text.DecimalFormat;

public class MyFormatter2  implements AxisValueFormatter {
    private DecimalFormat mFormat;
    public MyFormatter2() {
        //格式化数字
        mFormat = new DecimalFormat("###,###,##0.0");
    }
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mFormat.format(value) ;
    }

    @Override
    public int getDecimalDigits() {
        return 0;
    }

}