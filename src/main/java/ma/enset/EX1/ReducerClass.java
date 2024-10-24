package ma.enset;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ReducerClass extends Reducer<Text, LongWritable ,Text,LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
        long count = 0;        // Sum all the 1s for the city
        for (LongWritable value : values) {
            count += value.get();
        }
        // Write the result (ville, total des prix de ventes)
        context.write(key, new LongWritable(count));
    }
}
