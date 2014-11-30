package com.mapreduce.inverseindex;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class InverseIndexReducer extends MapReduceBase implements Reducer<Text, InverseIndex, Text, InverseIndex> {

	public void reduce(Text key, Iterator<InverseIndex> value,
			OutputCollector<Text, InverseIndex> output, Reporter reporter)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

}
