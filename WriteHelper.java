package smellProject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

public class WriteHelper {
	public String time =  String.valueOf(Calendar.DAY_OF_WEEK)+String.valueOf(Calendar.getInstance().getTimeInMillis());
    
    public String outputFile= MessageFormat.format("{0}-{1}-{2}.{3}", "testSmell","generalFixture",time, "csv");
    public FileWriter writer = new FileWriter(outputFile,false);

    public WriteHelper() throws IOException {
        
    }

    public void writeOutput(List<String> dataValues)throws IOException {
        writer = new FileWriter(outputFile,true);

        for (int i=0; i<dataValues.size(); i++) {
            writer.append(String.valueOf(dataValues.get(i)));

            if(i!=dataValues.size()-1)
                writer.append(",");
            else
                writer.append(System.lineSeparator());

        }
        writer.flush();
        writer.close();
    }
}
