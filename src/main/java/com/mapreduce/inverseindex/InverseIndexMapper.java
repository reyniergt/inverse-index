package com.mapreduce.inverseindex;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.Mapper;

public class InverseIndexMapper extends Mapper<LongWritable, Text, Text, InverseIndex> {
	
	private String sanitize(String word) {
		return word
                .replace(",", "")
                .replace("\\.", "")
                .replace("!", "")
                .replace("¡", "")
                .replace("?", "")
                .replace("¿", "")
                .replace("  ", " ")
                .toLowerCase().trim();
	}

	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, InverseIndex>.Context context)
			throws IOException, InterruptedException {
		FileSplit fileSplit = (FileSplit) context.getInputSplit();
		String fileName = fileSplit.getPath().getName();
		
		String line = value.toString();
		
		StringTokenizer tokenizer = new StringTokenizer(line);
		int pos = 1;
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			String word = sanitize(token);
			context.write(new Text(word), new InverseIndex(fileName, pos++));
		}
	}
	
	

}
