package com.mapreduce.inverseindex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class InverseIndexReducer extends Reducer <Text, InverseIndex, Text, InverseIndex> {

	@Override
	protected void reduce(Text key, Iterable<InverseIndex> value,
			Reducer<Text, InverseIndex, Text, InverseIndex>.Context context)
			throws IOException, InterruptedException {
		for (InverseIndex inverseIndex : value) {
			context.write(key, inverseIndex);
		}
	}
	
	

}
