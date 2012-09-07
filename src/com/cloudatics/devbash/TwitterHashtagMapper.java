package com.cloudatics.devbash;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TwitterHashtagMapper extends
		Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		
		String inputline = value.toString();
		
		String[] splitline = inputline.split("\\|");
		
		String pattern = "[\\\\#]+\\w+";
		
		if(splitline.length == 3){
			
			CharSequence str = splitline[2].toLowerCase().trim();
			
			Iterator tokens = new RETokenizer(str, pattern, false);
			
			for(; tokens.hasNext();){
				String token = (String)tokens.next();
				String newstr = token.replaceAll("#","");
				context.write(new Text(newstr), new IntWritable(1));
			}
		}
		
		
		
	}
}
