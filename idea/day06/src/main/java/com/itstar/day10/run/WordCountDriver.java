package com.itstar.day10.run;

import com.itstar.day10.wordcount.WordCountMapper;
import com.itstar.day10.wordcount.WordCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        // 1.创建job任务
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        // 2.指定jar包位置
        job.setJarByClass(WordCountDriver.class);
        // 3.关联使用的Mapper类
        job.setMapperClass(WordCountMapper.class);
        // 4.关联使用的Reducer类
        job.setReducerClass(WordCountReducer.class);
        // 5.设置Mapper阶段，输出的数据类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        // 6.设置Reducer阶段，输出数据类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // 7.设置数据输入的路径
        FileInputFormat.setInputPaths(job, new Path("E:\\localhost_201811230927_IDEAMyTest\\project\\day06\\in"));
        // 8.设置数据输出的路径
        FileOutputFormat.setOutputPath(job, new Path("E:\\localhost_201811230927_IDEAMyTest\\project\\day06\\out2"));
        // 9.提交任务
        boolean rs = job.waitForCompletion(true);
        System.exit(rs ? 0 : 1);
    }
}
