package com.itstar.day10.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dxw
 * @version 1.0 2019年2月13日 15:57:26
 * <p>
 * reducer：阶段接收的是Mapper输出的数据
 * mapper：的输出是reducer输入
 * <p>
 * keyIn：mapper输出的key的类型
 * valueIn：mapper输出的value的类型
 * <p>
 * reducer：端是输出的数据类型，想要一个什么杨的结果<hello,19888>
 * keyOut：Text
 * valueOut：IntWritable
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // 1.记录出现的次数
        int sum = 0;
        for (IntWritable v : values) {
            sum += v.get();
        }
        // 2.累加求和输出
        context.write(key, new IntWritable(sum));
    }
}