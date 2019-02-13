package com.itstar.day12.logs;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowCountReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
	// map的输出就是reducer的输入
	@Override
	protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
		long upFlow_sum = 0;
		long dfFlow_sum = 0;

		// 这里牵扯mapreduce_shuffle
		for (FlowBean v : values) {
			upFlow_sum += v.getUpFlow();
			dfFlow_sum += v.getDfFlow();
		}
		FlowBean rsSum = new FlowBean(upFlow_sum, dfFlow_sum);

		// 输出结果
		context.write(new Text(key), rsSum);

	}
}
