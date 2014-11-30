package com.mapreduce.inverseindex;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class InverseIndexMapper extends MapReduceBase implements Mapper<Text, Text, Text, InverseIndex> {
	
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

	public void map(Text key, Text value,
			OutputCollector<Text, InverseIndex> output, Reporter reporter)
			throws IOException {
		
		FileSplit fileSplit = (FileSplit) reporter.getInputSplit();
		String fileName = fileSplit.getPath().getName();
		
		String line = value.toString();
		
		StringTokenizer tokenizer = new StringTokenizer(line);
		int pos = 1;
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			String word = sanitize(token);
			output.collect(new Text(word), new InverseIndex(fileName, pos++));
		}
	}

}
