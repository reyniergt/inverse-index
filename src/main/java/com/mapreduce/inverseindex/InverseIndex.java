package com.mapreduce.inverseindex;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class InverseIndex implements Serializable, Writable {

	
	private static final long serialVersionUID = 4483222912367026797L;
	
	private String document;
	
	private int pos;

	public void readFields(DataInput arg0) throws IOException {
		Text documentWritable = new Text();
		documentWritable.readFields(arg0);
		document = documentWritable.toString();
		
		IntWritable posWritable = new IntWritable();
		posWritable.readFields(arg0);
		pos = posWritable.get();		
	}

	public void write(DataOutput arg0) throws IOException {
		new Text(document).write(arg0);
		new IntWritable(pos).write(arg0);		
	}
	
	public InverseIndex(String document, int pos) {
		this.document = document;
		this.pos = pos;
	}

}
