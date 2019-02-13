package com.itstar.day10.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author dxw
 * @version 1.0,2019年1月27日 20:51:40
 *
 * 海量数据
 *
 * helloitstar
 * mimi
 * 数据的输入与输出一key value进行传输
 * keyIN:LongWritable   是数据的起始偏移量
 * valueIN:具体数据Text
 *
 * mapper需要把数据传递到reducer阶段
 * keyOut:单词
 * valueOut:出现的次数IntWritable
 */
public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    // 对数据进行打散
    @Override
    public void map(LongWritable key, Text value,Context context) throws IOException, InterruptedException {
        // 1.接入数据 hello reba hello mimi

        String line = value.toString();
        // 2.对数据进行切分
        String[] words = line.split("\t");
        // 3.写出以<hello,1>
        for (String w:words){
            context.write(new Text(w),new IntWritable(1));
        }
    }
}