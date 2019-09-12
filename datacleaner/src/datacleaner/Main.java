package datacleaner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.datacleaner.api.AnalyzerResult;
import org.datacleaner.api.InputColumn;
import org.datacleaner.beans.stringpattern.PatternFinderResult;
import org.datacleaner.beans.writers.InsertIntoTableAnalyzer;
import org.datacleaner.beans.writers.WriteDataResult;
import org.datacleaner.configuration.DataCleanerConfigurationImpl;
import org.datacleaner.connection.CsvDatastore;
import org.datacleaner.connection.Datastore;
import org.datacleaner.job.AnalysisJob;
import org.datacleaner.job.builder.AnalysisJobBuilder;
import org.datacleaner.job.builder.AnalyzerComponentBuilder;
import org.datacleaner.job.runner.AnalysisResultFuture;
import org.datacleaner.job.runner.AnalysisRunner;
import org.datacleaner.job.runner.AnalysisRunnerImpl;
import org.datacleaner.result.AnalysisResult;
import org.datacleaner.result.SimpleAnalysisResult;
import org.datacleaner.util.ChangeAwareObjectInputStream;



public class Main {
	public static void main(String[] args) {
		try {

            // step 1 Configuration

            // xml 이용
//            InputStream inputStream = new FileInputStream("src/conf.xml");
//            JaxbConfigurationReader configurationReader = new JaxbConfigurationReader();
//            DataCleanerConfiguration dataCleanerConfiguration = configurationReader.read(inputStream);

            // 정적으로 datastore 이용
            Datastore datastore1 = new CsvDatastore("my CSV file", "src/nyc-jobs.csv");

            DataCleanerConfigurationImpl dataCleanerConfiguration2 = new DataCleanerConfigurationImpl();
            dataCleanerConfiguration2 = dataCleanerConfiguration2.withDatastores(datastore1);

            System.out.println("step 1 finish..");


            // step 2 Job

            Datastore myCsvFile = dataCleanerConfiguration2.getDatastoreCatalog().getDatastore("my CSV file");
            AnalysisJobBuilder jobBuilder = new AnalysisJobBuilder(dataCleanerConfiguration2);

            // SourceCoulumns 설정
            jobBuilder.setDatastore(datastore1);
            jobBuilder.addSourceColumns("Agency", "Level");

            InputColumn<?> agencyColumn = jobBuilder.getSourceColumnByName("Agency");
            InputColumn<?> levelColumn = jobBuilder.getSourceColumnByName("Level");

            // jobBuilder에 insertBuilder 설정
            AnalyzerComponentBuilder<InsertIntoTableAnalyzer> insertBuilder = jobBuilder.addAnalyzer(InsertIntoTableAnalyzer.class);
            insertBuilder.addInputColumns(agencyColumn, levelColumn);
            insertBuilder.setConfiguredProperty("Datastore", myCsvFile);
            insertBuilder.setConfiguredProperty("Column names", new String[] {"Agency", "Level"});

            // do job
            AnalysisJob analysisJob = jobBuilder.toAnalysisJob();
            System.out.println("step 2 finish..");

            // step 3 Execution

            // runner 설정
            AnalysisRunner runner = new AnalysisRunnerImpl(dataCleanerConfiguration2);

            // run
            AnalysisResultFuture resultFuture = runner.run(analysisJob);
            System.out.println("step 3 finish..");


            // step 4 Result

            AnalysisResult analysisResult = resultFuture;
            List<AnalyzerResult> results = analysisResult.getResults();
            for (AnalyzerResult result : results) {

                if (result instanceof WriteDataResult) {
                    WriteDataResult writeDataResult = (WriteDataResult)result;
                    System.out.println("Inserted " + writeDataResult.getWrittenRowCount() + " records");
                }

                if (result instanceof PatternFinderResult) {
                    PatternFinderResult patternFinderResult = (PatternFinderResult)result;
                    int matches = patternFinderResult.getMatchCount("Aaaaa Aaaaa");
                    //int total = patternFinderResult.getTotalCount();
                    System.out.println("There where " + matches + " matches out of " + " for our standard pattern.");
                }
            }

            // result output

            analysisResult = new SimpleAnalysisResult(analysisResult.getResultMap());

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("my_result.analysis.result.dat"));
            oos.writeObject(analysisResult);
            
            ObjectInputStream ois = new ChangeAwareObjectInputStream(new FileInputStream("my_result.analysis.result.dat"));
            AnalysisResult analysisResult2 = (AnalysisResult) ois.readObject();

            List<AnalyzerResult> resultList = analysisResult2.getResults();
            for(AnalyzerResult a : resultList)
            	System.out.println("hi" + a);
            
            oos.close();
            ois.close();
            System.out.println("step 4 finish..");
        }catch (Exception e){
            e.printStackTrace();
        }
	}
}
