package ma.enset;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MapperClass extends Mapper<LongWritable, Text, Text, LongWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context) throws IOException, InterruptedException {
        String words[]=value.toString().split(" ");
        //Calculer nb de ventes par villes
        // Extract ville

        String ville=words[1];
        String prix=words[3];
        //context.write(new Text(ville),new LongWritable(1));*/

        //Calculer prix total des ventes pour chaque villes
        context.write(new Text(ville),new LongWritable(Long.parseLong(prix)));

    }
}
