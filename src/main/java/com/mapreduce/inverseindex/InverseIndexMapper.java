package com.mapreduce.inverseindex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class InverseIndexMapper extends MapReduceBase implements Mapper<Text, Text, Text, InverseIndex> {

	public void map(Text key, Text value,
			OutputCollector<Text, InverseIndex> output, Reporter reporter)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

}
