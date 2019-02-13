package com.itstar.day121.logs;

import com.itstar.day121.logs.FlowBean;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * FlowSortMapper class
 *
 * @author dxw
 * @version 1.0
 * @date 2019年2月11日 21:40:24
 */
public class FlowSortMapper extends Mapper<LongWritable, Text, FlowBean, Text> {

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		// 1.接入数据
		String line = value.toString();

		// 2.切割
		String[] fields = line.split("\t");

		// 3.拿到关键字段:手机号 上行流量 下行流量
		String phoneNo = fields[0];
		long upFlow = Long.parseLong(fields[1]);
		long dfFlow = Long.parseLong(fields[2]);

		// 4.写出到reducer map的输出就是reducer的输入
		context.write(new FlowBean(upFlow, dfFlow), new Text(phoneNo));
	}
}
