## Commands

Als erstes holen wir uns via wget zwei Dict - files:
``` 
[cloudera@quickstart ~]$ wget http://www.ilovelanguages.com/IDP/files/French.txt
--2016-01-16 06:43:44--  http://www.ilovelanguages.com/IDP/files/French.txt
Resolving www.ilovelanguages.com... 64.71.34.99
Connecting to www.ilovelanguages.com|64.71.34.99|:80... connected.
HTTP request sent, awaiting response... 200 OK
Length: 87369 (85K) [text/plain]
Saving to: “French.txt”

100%[======================================>] 87,369       221K/s   in 0.4s    

2016-01-16 06:43:44 (221 KB/s) - “French.txt” saved [87369/87369]

[cloudera@quickstart ~]$ wget http://www.ilovelanguages.com/IDP/files/German.txt
--2016-01-16 06:43:51--  http://www.ilovelanguages.com/IDP/files/German.txt
Resolving www.ilovelanguages.com... 64.71.34.99
Connecting to www.ilovelanguages.com|64.71.34.99|:80... connected.
HTTP request sent, awaiting response... 200 OK
Length: 211008 (206K) [text/plain]
Saving to: “German.txt”

100%[======================================>] 211,008      279K/s   in 0.7s    

2016-01-16 06:43:52 (279 KB/s) - “German.txt” saved [211008/211008]

```
Danach pipen wir beide Dateien in eine, schieben diese ins HDFS und checken, ob sie auch da ist
```
[cloudera@quickstart ~]$ cat French.txt >> dictionary.txt
[cloudera@quickstart ~]$ cat German.txt >> dictionary.txt
[cloudera@quickstart ~]$ vim dictionary.txt 
[cloudera@quickstart ~]$ hadoop fs -put dictionary.txt 
[cloudera@quickstart ~]$ hdfs dfs -ls
Found 2 items
-rw-r--r--   1 cloudera cloudera     298377 2016-01-16 06:51 dictionary.txt
drwxr-xr-x   - cloudera cloudera          0 2016-01-13 01:34 example
```

Nachdem wir eine .jar datei in Eclipse erstellt haben, geben wir yarn die .jar datei, inklusive input- und outputpfad

``` 
[cloudera@quickstart ~]$ yarn jar dict.jar dictionary.txt out1/
16/01/16 06:56:09 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
16/01/16 06:56:09 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
16/01/16 06:56:10 INFO input.FileInputFormat: Total input paths to process : 1
16/01/16 06:56:10 INFO mapreduce.JobSubmitter: number of splits:1
16/01/16 06:56:10 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1452953214935_0001
16/01/16 06:56:11 INFO impl.YarnClientImpl: Submitted application application_1452953214935_0001
16/01/16 06:56:11 INFO mapreduce.Job: The url to track the job: http://quickstart.cloudera:8088/proxy/application_1452953214935_0001/
16/01/16 06:56:11 INFO mapreduce.Job: Running job: job_1452953214935_0001
16/01/16 06:56:24 INFO mapreduce.Job: Job job_1452953214935_0001 running in uber mode : false
16/01/16 06:56:24 INFO mapreduce.Job:  map 0% reduce 0%
16/01/16 06:56:33 INFO mapreduce.Job:  map 100% reduce 0%
16/01/16 06:56:44 INFO mapreduce.Job:  map 100% reduce 100%
16/01/16 06:56:45 INFO mapreduce.Job: Job job_1452953214935_0001 completed successfully
16/01/16 06:56:46 INFO mapreduce.Job: Counters: 49
	File System Counters
		FILE: Number of bytes read=333493
		FILE: Number of bytes written=890829
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=298502
		HDFS: Number of bytes written=273077
		HDFS: Number of read operations=6
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=7206
		Total time spent by all reduces in occupied slots (ms)=9151
		Total time spent by all map tasks (ms)=7206
		Total time spent by all reduce tasks (ms)=9151
		Total vcore-seconds taken by all map tasks=7206
		Total vcore-seconds taken by all reduce tasks=9151
		Total megabyte-seconds taken by all map tasks=7378944
		Total megabyte-seconds taken by all reduce tasks=9370624
	Map-Reduce Framework
		Map input records=13000
		Map output records=13707
		Map output bytes=306073
		Map output materialized bytes=333493
		Input split bytes=125
		Combine input records=0
		Combine output records=0
		Reduce input groups=8054
		Reduce shuffle bytes=333493
		Reduce input records=13707
		Reduce output records=8054
		Spilled Records=27414
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=142
		CPU time spent (ms)=3450
		Physical memory (bytes) snapshot=355463168
		Virtual memory (bytes) snapshot=3008643072
		Total committed heap usage (bytes)=226365440
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=298377
	File Output Format Counters 
		Bytes Written=273077
```
Wir sehen, dass ein erfolgreiches Output generiert wurde, und schauen uns den Inhalt direkt an: 
``` 
[cloudera@quickstart ~]$ hdfs dfs -ls out1/
Found 2 items
-rw-r--r--   1 cloudera cloudera          0 2016-01-16 06:56 out1/_SUCCESS
-rw-r--r--   1 cloudera cloudera     273077 2016-01-16 06:56 out1/part-r-00000
[cloudera@quickstart ~]$ hdfs dfs -tail out1/part-r-00000
punkt (m)|z�ro
zeroes	|Nullen[Noun]
zeros	|Nullen
zeroth	| die das) Nullte[Noun]|(der
zest	|Begeisterung (f)|Lust| Gefallen|piquant[Noun]
zigzag	|zigzaguer[Verb]|Zickzack| im Zickzack (laufen etc.)|Zickzack (m)
zigzagged	|Zickzack-[Adjective]
zinc	|zinc[Noun]|Zink[Noun]
zip	|Surren
zipped	|mit Reissverschluss[Adjective]
zipper	|fermeture[Noun]|Reissverschluss|Rei�verschlu� (m)|Schnellverschlu� (m)
zippers	|Reissverschlu.sse
zither	|Zither
zitherist	|Zitherspieler
zloty	|Zloty (poln. Wa.hrung)[Noun]
zlotys	|Zlotys (poln. Wa.hrung)[Noun]
zodiac	|zodiaque[Noun]|zondiaque[Noun]|tierkreis|Tierkreis|Sternzeichen[Noun]
zodiacal	|Tierkreis-
zombi	|Zombi[Noun]
zombie	|Trant�te (f)
zone	|Zone (f)|zone[Noun]|zone[Noun]|Gebiet (n)
zones	|Zonen[Noun]
zoo	|Zoo (m)|zoo[Noun]
zoologic	|zoologisch[Adjective]
zoological	|zoologisch
zoologist	|Zoologe[Noun]
zoologists	|Zoologen[Noun]
zoology	|Zoologie[Noun]|zoologie[Noun]
zoom	|zoomen[Verb]|aller en trombe[Verb]
zoos	| Tierga.rten[Noun]|Zoos
zucchini	|courgette[Noun]
``` 
Somit sehen wir, dass aus den zwei Woerterbuechern eins gemacht wurde, und die englischen Begriffe nun in Deutsch und
Franzoesisch, getrennt durch | zu finden sind. 


