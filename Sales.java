import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Sales {
    public static void main(String[] args) {
        BufferedReader Buffer = null;

        try {
            String Line;
            Buffer = new BufferedReader(new FileReader("Data.csv"));

            // How to read file in java line by line?
            while ((Line = Buffer.readLine()) != null) {
                System.out.println("Raw CSV data: " + Line);
                System.out.println("Converted ArrayList data: " + CSVtoArrayList(Line) + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Buffer != null) Buffer.close();
            } catch (IOException Exception) {
                Exception.printStackTrace();
            }
        }
    }

    // Utility which converts CSV to ArrayList using Split Operation
    public static ArrayList<String> CSVtoArrayList(String CSV) {
        ArrayList<String> Result = new ArrayList<String>();

        if (CSV != null) {
            String[] splitData = CSV.split("\\s*,\\s*");
            for (int i = 0; i < splitData.length; i++) {
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    Result.add(splitData[i].trim());
                }
            }
        }

        return Result;
    }
}
