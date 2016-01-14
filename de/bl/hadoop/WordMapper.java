package de.bl.hadoop;

 
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
 
/**
 * This classs is the Mapper Class
 * @author Ben Lohrengel
 *
 */
public class WordMapper extends Mapper<Text,Text,Text,Text> {
 
    private Text word = new Text();
 
    public void map(Text key, Text value, Context context) throws IOException, InterruptedException
    {
        StringTokenizer itr = new StringTokenizer(value.toString(),",");
        while (itr.hasMoreTokens())
        {
            word.set(itr.nextToken());
            context.write(key, word);
        }
    }
}
