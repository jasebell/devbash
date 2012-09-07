# Devbash BigData Code
The source code in this repo accompanies the talk from the BigData Bash in Belfast on September 12th 2012 along with [Matt Biddulph](https://github.com/mattb) and [Jim Webber](https://github.com/jimwebber).

## Requirements
This project requires the Hadoop core jar library in the lib folder. You'll see the core jar file by the naming of your Hadoop distribution (hadoop-core-0.20.2-cdh3u3.jar for example).  If you don't have Hadoop you can download it from [Apache](http://hadoop.apache.org) or the likes of [Cloudera](http://www.cloudera.com).

To build the example jar file run the ant build file from the command line:

	ant dist

This will build the jar file to the dist directory.  You can either reference the jar file in your classpath or copy it to your specific project directory before use.

## Source data for the demo

The original MTV EMA 2011 data was kindly donated to [Datasentiment/Cloudatics](http://www.datasentiment.com) by [Repknight](http://www.repknight.com) so I'm afraid I'm in no position to supply the data here.  The format used is easy to work with though, basically it's pipe delimited.

	TwitterHandle|yyyy-mm-dd hh:mm:ss|TweetContent

So there's nothing to stop you using any type of delimited content. 

## Running Hadoop with the jar
The demo contains two MapReduce jobs, first one to extract users and count their frequency:

	hadoop jar devbash.jar com.cloudatics.devbash.TwitterMentionJob input output

The second works with the hashtag.

	hadoop jar devbash.jar com.cloudatics.devbash.TwitterHashtagJob input output

## Make contact
For any questions please direct them to Jason Bell via email <jasebell@gmail.com> or keep an eye on the blog [DataIsSexy](http://www.dataissexy.co.uk). 


