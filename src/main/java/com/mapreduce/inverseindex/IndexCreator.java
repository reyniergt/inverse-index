package com.mapreduce.inverseindex;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class IndexCreator {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		
		try {
			Job job = Job.getInstance(configuration, "inverted index job");
			job.setJarByClass(IndexCreator.class);
			job.setMapperClass(InverseIndexMapper.class);
			job.setReducerClass(InverseIndexReducer.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(InverseIndex.class);
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));			
			
			job.waitForCompletion(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
