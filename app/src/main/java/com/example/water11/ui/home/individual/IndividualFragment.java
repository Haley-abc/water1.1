package com.example.water11.ui.home.individual;

import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.water11.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;

import java.util.ArrayList;


public class IndividualFragment extends Fragment {

    private IndividualViewModel mViewModel;
    private PieChart pieChart1;
    private BarChart barChart;

    public static IndividualFragment newInstance() {
        return new IndividualFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.individual_fragment, container, false);
        pieChart1=root.findViewById(R.id.consume_pie1_chart);
        barChart=root.findViewById(R.id.bar_chart);
        chart2();
        initBarChart1();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(IndividualViewModel.class);
        // TODO: Use the ViewModel
    }

    private void chart2(){
        pieChart1.setUsePercentValues(true);
        pieChart1.setDrawCenterText(false); //设置可以绘制中间的文字
        pieChart1.setDrawHoleEnabled(false); //绘制中间的圆形
        pieChart1.setDescription("");
        pieChart1.setRotationEnabled(false);//设置饼状图是否可以旋转(默认为true)
        pieChart1.setRotationAngle(10);//设置饼状图旋转的角度
        Legend l = pieChart1.getLegend(); //设置比例图
        l.setMaxSizePercent(100);
        l.setTextSize(10);
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);//设置每个tab的显示位置（这个位置是指下图右边小方框部分的位置 ）
        l.setXEntrySpace(20f);
        l.setYEntrySpace(10f);//设置tab之间Y轴方向上的空白间距值
        l.setYOffset(0f);

        //饼状图上字体的设置
        pieChart1.setDrawEntryLabels(true);//设置是否绘制Label
        // pieChart1.setEntryLabelColor(Color.BLACK);//设置绘制Label的颜色
        pieChart1.setEntryLabelTextSize(8f);//设置绘制Label的字体大小

        ArrayList<PieEntry> pieEntries = new ArrayList<PieEntry>();
        pieEntries.add(new PieEntry(25, "洗浴"));
        pieEntries.add(new PieEntry(19, "洗衣"));
        pieEntries.add(new PieEntry(12, "洗漱"));
        pieEntries.add(new PieEntry(30, "饮用"));
        pieEntries.add(new PieEntry(14, "冲厕"));
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        ArrayList<Integer> colors = new ArrayList<>();

        // 饼图颜色
        colors.add(Color.rgb(24, 52, 91));
        colors.add(Color.rgb(92, 116, 146));
        colors.add(Color.rgb(137, 170, 215));
        colors.add(Color.rgb(62, 139, 199));
        colors.add(Color.rgb(62, 215, 220));
        pieDataSet.setColors(colors);

        pieDataSet.setSliceSpace(0f);//设置选中的Tab离两边的距离
        pieDataSet.setSelectionShift(5f);//设置选中的tab的多出来的
        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);

        //各个饼状图所占比例数字的设置
        pieData.setValueFormatter(new PercentFormatter());//设置%
        pieData.setValueTextSize(8f);
        pieData.setValueTextColor(Color.WHITE);

        pieChart1.setData(pieData);
        pieChart1.highlightValues(null);
        pieChart1.invalidate();
    }
    private void initBarChart1() {

        barChart.setDrawValueAboveBar(true);  //设置所有的数值在图形的上面,而不是图形上
        barChart.setTouchEnabled(false);  //进制触控
        barChart.setScaleEnabled(false); //设置能否缩放
        barChart.setPinchZoom(false);  //设置true支持两个指头向X、Y轴的缩放，如果为false，只能支持X或者Y轴的当方向缩放
        barChart.setDrawBarShadow(false);  //设置阴影
        barChart.setDrawGridBackground(false);  //设置背景是否网格显示
        barChart.setDescription(""); //不描述

        //X轴的数据格式
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new MyFormatter());
        //设置位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置是否绘制网格线
        xAxis.setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        // barChart.animateY(2500);
        //设置X轴文字剧中对齐
        xAxis.setCenterAxisLabels(false);
        //X轴最小间距
        xAxis.setGranularity(1f);


        //Y轴的数据格式
        YAxis axisLeft = barChart.getAxisLeft();
        axisLeft.setValueFormatter(new MyFormatter2());
        barChart.animateY(2500);
        //设置Y轴刻度的最大值
        axisLeft.setAxisMinValue(0);
        axisLeft.setAxisMaxValue(300);
        barChart.getAxisRight().setEnabled(false);

        //设置数据
        setData01();

    }

    //日对比的数据
    private void setData01() {
        ArrayList<BarEntry> yVals1 = new ArrayList<>();
        yVals1.add(new BarEntry(1, 140));
        yVals1.add(new BarEntry(2, 214));
        yVals1.add(new BarEntry(3, 200));

        BarDataSet set1;
        set1 = new BarDataSet(yVals1, "");
        //设置多彩 也可以单一颜色
        set1.setColor(Color.parseColor("#4169E1"));
        set1.setDrawValues(false);
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        BarData data = new BarData(dataSets);
        barChart.setData(data);
        barChart.setFitBars(true);
        //设置文字的大小
        set1.setValueTextSize(12f);
        //设置每条柱子的宽度
        data.setBarWidth(0.5f);
        barChart.invalidate();

        for (IDataSet set : barChart.getData().getDataSets())
            set.setDrawValues(!set.isDrawValuesEnabled());
        barChart.invalidate();
        barChart.setAutoScaleMinMaxEnabled(!barChart.isAutoScaleMinMaxEnabled());
        barChart.notifyDataSetChanged();
        barChart.invalidate();

    }
}
