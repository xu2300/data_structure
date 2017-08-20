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
public class dash_log2 {


    public static void main(String[] args) throws ParseException, IOException {
        String outPutDir = "/Users/junweixu/Desktop/43/steel_1/miss3/";
        List<List<String>> lines = getLinesContainNeedle(outPutDir+"logcat.txt");
        String startTime = getStartTime(lines.get(3));
        List<String> BufferSize = readBufferSize(lines.get(0));
        List<Double> BufferTime = readBufferTime(lines.get(0),startTime);
        outputDoubleToTxt(BufferTime,outPutDir+"bufferTime");
        outputStringToTxt(BufferSize,outPutDir+"bufferSize");

        List<Double> rePresentation = getRepresentation(lines.get(2));
        outputDoubleToTxt(rePresentation,outPutDir+"rePresentation");
        List<Double> rePreTime = readRepreTime(lines.get(1),startTime);
        outputDoubleToTxt(rePreTime,outPutDir+"rePreTime");
    }


    public static void outputDoubleToTxt(List<Double> arr,String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for(Double ob: arr) {
            writer.write(String.valueOf(ob));
            writer.newLine();
        }
        writer.close();
    }

    public static void outputStringToTxt(List<String> arr,String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for(String ob: arr) {
            writer.write(ob);
            writer.newLine();
        }
        writer.close();
    }



    public static List<List<String>> getLinesContainNeedle(String filePath) {
        List<List<String>> re = new ArrayList<List<String>>();
        List<String> buffer1 = new ArrayList<String>();
        List<String> buffer2 = new ArrayList<String>();
        List<String> buffer3 = new ArrayList<String>();
        List<String> buffer4 = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        String lineTxt = null;
        String needle1 = "[DASH] total is";
        String needle2 = "[DASH] AS#1 got";
        String needle3 = "[DASH] Added file to cache";
        String needle4 = "Connecting to http://164.107.116.117/";
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((lineTxt = bufferedReader.readLine()) != null){
                if(lineTxt.indexOf(needle1)!=-1) buffer1.add(lineTxt);
                else if(lineTxt.indexOf(needle2)!=-1) buffer2.add(lineTxt);
                else if(lineTxt.indexOf(needle3)!=-1) buffer3.add(lineTxt);
                else if(lineTxt.indexOf(needle4)!=-1) buffer4.add(lineTxt);
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        re.add(buffer1);
        re.add(buffer2);
        re.add(buffer3);
        re.add(buffer4);
        return re;
    }



    public static List<Double> getRepresentation(List<String> buffer){
        String needle1 = "s_";
        String needle2 = "bp";
        List<Double> re = new ArrayList();
        re.add((double)0);
        for(String s : buffer){
            int start = s.indexOf(needle1);
            int end = s.lastIndexOf(needle2);
            double rePresentation = Double.valueOf(s.substring(start+2,end));
            rePresentation = rePresentation/1000;
            re.add(rePresentation);
            re.add(rePresentation);
            re.add((double)0);
            re.add((double)0);
        }
        return re;
    }

    public static List<Double> readRepreTime(List<String> buffer, String startTime) throws ParseException {
        List<Double> re = new ArrayList();
        String time1 = startTime;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
        String needle1 = "in";
        String needle2 = "se";
        for(String s: buffer){
            String time3 = s.substring(s.indexOf(needle1)+3,s.indexOf(needle2)-1);
            String time2 = s.substring(6,18);
            Date date1 = format.parse(time1);
            Date date2 = format.parse(time2);
            Double end = (double)date2.getTime() - date1.getTime();
            end = end/1000;
            Double start = end - Double.valueOf(time3);
            re.add(start);
            re.add(start);
            re.add(end);
            re.add(end);
        }
        return re;
    }

    public static List<Double> readBufferTime(List<String> buffer, String startTime) throws ParseException {
        List<Double> re = new ArrayList();
        String time1 = startTime;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
        for(String s: buffer){
            String time2 = s.substring(6,18);
            Date date1 = format.parse(time1);
            Date date2 = format.parse(time2);
            Double difference = (double)date2.getTime() - date1.getTime();
            re.add(difference/1000);
        }
        return re;
    }


    public static List<String> readBufferSize(List<String> buffer) {
        List<String> re = new ArrayList();
        String needle1 = "is";
        String needle2 = "ms";
        for(String s: buffer){
            re.add(s.substring(s.indexOf(needle1)+3,s.indexOf(needle2)-1));
        }
        return re;
    }

    public static String getStartTime(List<String> buffer){
        return buffer.get(0).substring(6,18);
    }


   /*
    public static boolean zeroBuffer(String needle1, String needle2, String s){
        int start = s.indexOf(needle1);
        int end = s.indexOf(needle2);
        String bufferLength = s.substring(start+3,end-1);
        if(bufferLength.equals("0")) return true;
        else return  false;
    }*/

}
