package de.fhms.bl.bde_Uebung2;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import java.io.IOException;

/**
 * Reducer class
 * Reduces a set of intermediate values which share a key to a smaller set of values. 
 * @author Ben Lohrengel
 */

public class TranslationsReducer extends Reducer<Text, Text, Text, Text> {

	private Text result = new Text();

	@Override
	protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		String translations = "";

		// fuer jeden val in values wird ein String an translation gehangen, getrennt durch |  
		for (Text val : values) {
			translations += "|" + val.toString();
		}

		result.set(translations);
		context.write(key, result);
	}
}