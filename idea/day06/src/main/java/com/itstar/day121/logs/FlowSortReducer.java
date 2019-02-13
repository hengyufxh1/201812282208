package com.itstar.day121.logs;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.itstar.day121.logs.FlowBean;

public class FlowSortReducer extends Reducer<FlowBean, Text, Text, FlowBean> {
	@Override
	protected void reduce(FlowBean key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		context.write(values.iterator().next(), key);
	}

}