package com.itstar.day12.run;


import com.itstar.day12.logs.FlowBean;
import com.itstar.day12.logs.FlowCountMapper;
import com.itstar.day12.logs.FlowCountReducer;
import com.itstar.day12.logs.PhonenumPartitioner;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author dxw
 * @version 1.0 2019年1月30日 21:46:23
 *
 */
public class FlowCountDriver {

    public static void main(String [] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 1.创建job任务
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        // 2.指定jar包位置
        job.setJarByClass(FlowCountDriver.class);
        // 3.关联使用的Mapper类
        job.setMapperClass(FlowCountMapper.class);
        // 4.关联使用的Reducer类
        job.setReducerClass(FlowCountReducer.class);
        // 5.设置Mapper阶段，输出的数据类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        // 6.设置Reducer阶段，输出的数据类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        // 设置读取数据切片的类
        job.setInputFormatClass(CombineTextInputFormat.class);
        // 最大切片大小 8M
        CombineTextInputFormat.setMaxInputSplitSize(job,8388608);
        // 最小切片大小 6M
        CombineTextInputFormat.setMinInputSplitSize(job,6291456);

        // 加入自定义分区
        job.setPartitionerClass(PhonenumPartitioner.class);
        // 注意：结果文件几个？
        // 指定分区结果
        job.setNumReduceTasks(5);

        // 7.设置输出输入的路径
        FileInputFormat.setInputPaths(job, new Path("E:\\localhost_201811230927_IDEAMyTest\\project\\day06\\in"));
        // 8.设置数据输出的路径
        FileOutputFormat.setOutputPath(job, new Path("E:\\localhost_201811230927_IDEAMyTest\\project\\day06\\out"));
        // 9. 提交任务
        boolean rs = job.waitForCompletion(true);
        System.exit(rs?0:1);
    }
}
