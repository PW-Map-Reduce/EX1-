package ma.enset.EX1;

import org.apache.hadoop.conf.Configuration;  // Correction ici
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

public class MainDriver {
    public static void main(String[] args) throws Exception {
        // Utilisation de la classe Configuration de Hadoop
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(MainDriver.class);  // Définit la classe principale du Jar

        job.setMapperClass(MapperClass.class);
        job.setReducerClass(ReducerClass.class);

        job.setInputFormatClass(TextInputFormat.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));  // Input path (ventes.txt)
        FileOutputFormat.setOutputPath(job, new Path(args[1])); // Output path

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
