package com.itstar.day10.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dxw
 * @version 1.0,2019年1月27日 20:51:40
 *
 * reducer:阶段接受是Mapper输出的数据
 * mapper:的输出是reducer输入
 *
 * keyIN:mapper输出的key的类型
 * valueIN:mapper输出的value的类型
 *
 * reducer端是输出的数据类型，想要一个什么样的结果<hello,19888>
 * keyOut:Text
 * valueOut:Intwritable
 */
public class WordCountReducer extends Reducer<Text,IntWritable, Text, IntWritable> {
    // key->单词 values->次数 111111

    // 对数据进行聚合
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        // 1.记录出现的次数
        int sum = 0;
        for(IntWritable v:values){
            sum += v.get();
        }

        // 2.累加求和输出
        context.write(key,new IntWritable(sum));
    }
}
