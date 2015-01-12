package DataProcessing;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 1/25/14
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class xad {

    protected static class pair{
        int count;
        double score;

        public pair(int count,double score){
            this.count = count;
            this.score = score;
        }
        public double getAvg(){
            return (score/count);
        }
        public void addScoreAndCount(double score){
            this.score+=score;
            this.count++;
        }
    }

    public static void main(String[] args) {
        String webExtractFile = "C:\\Karthik\\Interviews\\WebExtract.txt";
        String cuisineFile = "C:\\Karthik\\Interviews\\Cuisine.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        HashMap<String,HashMap<String,Integer>> dataMap = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String,pair> cuisineMap = new HashMap<String, pair>();

        try {

            br = new BufferedReader(new FileReader(webExtractFile));
            line=br.readLine(); // Just to skip the first row that contains column name
            while ((line = br.readLine()) != null) {

                String[] restaurantData = line.split(cvsSplitBy);
                // Replacing occurances of quotes (") in the string to avoid issues
                String zip = restaurantData[5].replace("\"","");
                String cuisineCode = restaurantData[7].replace("\"","");
                String date = restaurantData[8].split(" ")[0].replace("\"","");
                Integer score = 0;
                try{
                    score = new Integer(restaurantData[11].replace("\"",""));
                }catch(NumberFormatException e){
                    score=0;
                }

                HashMap<String ,Integer> temp = null;
                if(dataMap.get(date)==null){
                    temp = new HashMap<String, Integer>();
                    temp.put(zip,1);
                    dataMap.put(date,temp);
                }else{
                    temp = dataMap.get(date);
                    if(temp.get(zip)==null){
                        temp.put(zip,1);
                    }else{
                        int curCount = temp.get(zip);
                        temp.put(zip,curCount+1);
                    }
                }

                if(score==0)  // to exclude rows with invalid score, so that they dont affect average
                    continue;

                if(cuisineMap.get(cuisineCode)==null){
                    cuisineMap.put(cuisineCode,new pair(1,score));
                }else{
                    cuisineMap.get(cuisineCode).addScoreAndCount(score);
                }
            }

            br.close();
            //Reading the Cuisine Description File
            br = new BufferedReader(new FileReader(cuisineFile));
            line=br.readLine(); // skipping first row which contains column names
            HashMap<String,String> cuisineCodeMap= new HashMap<String, String>();
            while((line=br.readLine())!=null){
                String[] cuisineDesc = line.split(cvsSplitBy);
                cuisineCodeMap.put(cuisineDesc[0].replace("\"",""),cuisineDesc[1].replace("\"",""));
            }

            PrintWriter writer = new PrintWriter("DayWiseZipWise.csv", "UTF-8");
            //Printing DayWise, ZIPWise Data
            for(Map.Entry<String,HashMap<String,Integer>> dateEntry: dataMap.entrySet()){
                if(dateEntry.getKey().equals("")) continue; // Weed out corrupt data
                for(Map.Entry<String,Integer> zipEntry: dateEntry.getValue().entrySet()){
                        writer.println(dateEntry.getKey() + "," + zipEntry.getKey() + "," + zipEntry.getValue());
                    }
            }
            writer.close();
            writer = new PrintWriter("AvgScores.csv", "UTF-8");

            //Printing the Average Scores
            for(Map.Entry<String,pair> entry : cuisineMap.entrySet()){
                if(cuisineCodeMap.get(entry.getKey())!=null)// Not considering Junk values
                     writer.println(cuisineCodeMap.get(entry.getKey()) + "," + entry.getValue().getAvg());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            System.out.println(line);
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
