package design;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Created by junweixu on 3/12/17.
 */
public class last {


    public static void main(String[] args) throws ParseException, IOException {
        String outPutDir = "/Users/junweixu/Desktop/3:13/6/";
        List<String> lines = getLinesContainNeedle(outPutDir+"logcat.txt");

        outputStringToTxt(lines,outPutDir+"temple");

    }




    public static void outputStringToTxt(List<String> arr,String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for(String ob: arr) {
            writer.write(ob);
            writer.newLine();
        }
        writer.close();
    }



    public static List<String> getLinesContainNeedle(String filePath) {
        List<String> buffer1 = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        String lineTxt = null;
        String needle1 = "[DASH] Downloading ";
        String needle2 = "[DASH] deleting";
        String needle3 = "kbps - buffer";
        String needle4 = "total is";
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((lineTxt = bufferedReader.readLine()) != null){
                if(lineTxt.indexOf(needle1)!=-1) buffer1.add(lineTxt);
                if(lineTxt.indexOf(needle2)!=-1) buffer1.add(lineTxt);
                if(lineTxt.indexOf(needle3)!=-1) buffer1.add(lineTxt);
               // if(lineTxt.indexOf(needle4)!=-1) buffer1.add(lineTxt);
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return buffer1;
    }




}
