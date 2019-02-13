package com.itstar.day121.logs;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author dxw
 * @version 1.0 2019年1月30日 21:12:05
 *
 *          封装的数据类型需要怎么做 hadoop数据类型实现了序列化接口 如果自定义需要实现中国序列化接口
 */
public class FlowBean implements WritableComparable<FlowBean> {

	// 定义属性：上行流量 下行流量 总流量综合
	private long upFlow;
	private long dfFlow;
	private long flowSum;

	public FlowBean() {
	}

	public FlowBean(long upFlow, long dfFlow) {
		this.upFlow = upFlow;
		this.dfFlow = dfFlow;
		this.flowSum = upFlow + dfFlow;
	}

	public long getUpFlow() {
		return upFlow;
	}

	public void setUpFlow(long upFlow) {
		this.upFlow = upFlow;
	}

	public long getDfFlow() {
		return dfFlow;
	}

	public void setDfFlow(long dfFlow) {
		this.dfFlow = dfFlow;
	}

	public long getFlowSum() {
		return flowSum;
	}

	public void setFlowSum(long flowSum) {
		this.flowSum = flowSum;
	}

	// 序列化
	public void write(DataOutput out) throws IOException {
		out.writeLong(upFlow);
		out.writeLong(dfFlow);
		out.writeLong(flowSum);
	}

	// 反序列化
	public void readFields(DataInput in) throws IOException {
		upFlow = in.readLong();
		dfFlow = in.readLong();
		flowSum = in.readLong();
	}

	@Override
	public String toString() {
		return upFlow + "\t" + dfFlow + "\t" + flowSum;
	}

	public int compareTo(FlowBean o) {
		// 倒序流量多的-1:1
		// 正序排序 1:-1
		return this.flowSum > o.getFlowSum() ? -1 : 1;
	}
}
