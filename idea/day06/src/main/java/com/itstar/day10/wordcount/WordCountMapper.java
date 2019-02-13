package com.itstar.day10.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author dxw
 * @version 1.0 2019年2月13日 15:50:12
 * <p>
 * hello itstar
 * hello mimi
 * 数据的输入与输出，key value 进行传输
 * keyIn：LongWritable 是数据的起始偏移量
 * valueIn：具体数据Text
 * <p>
 * mapper需要把数据传递到reducer阶段
 * keyOut：单词
 * valueOut：出现的次数IntWritable
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1.接入数据 hello reba hello mimi
        String line = value.toString();
        // 2.数据进行切分
        String[] words = line.split("\t");
        // 3.写出以<hello,1>
        for (String s : words) {
            context.write(new Text(s), new IntWritable(1));
        }
    }
}
