package com.itstar.day121.logs;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * Demo class
 *
 * @author dxw
 * @version 1.0
 */
public class FlowSortPartitioner extends Partitioner<FlowBean, Text> {

	@Override
	public int getPartition(FlowBean key, Text values, int numPartitions) {
		// 1.根据手机号的前三位 切分字段
		// 当前的Text values截取 string.substring
		String phoneNum = values.toString().substring(0, 3);

		// 2.分区判断 135 138 判断分区段
		int partitioner = 4;
		if ("135".equals(phoneNum)) {
			return 0;
		} else if ("137".equals(phoneNum)) {
			return 1;
		} else if ("138".equals(phoneNum)) {
			return 2;
		} else if ("139".equals(phoneNum)) {
			return 3;
		}
		return partitioner;
	}
}
