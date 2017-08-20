package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
public class MorseEncodeandDecode {

        HashMap<String, String> hm;
        HashMap<String, String> hmd;

        public MorseEncodeandDecode() {
                hm = new HashMap<>();
                hmd = new HashMap<>();
                hm.put("A", ".-");
                hm.put("B", "-...");
                hm.put("C", "-.-.");
                hm.put("D", "-..");
                hm.put("E", ".");
                hm.put("F", "..-.");
                hm.put("G", "--.");
                hm.put("H", "....");
                hm.put("I", "..");
                hm.put("J", ".---");
                hm.put("K", "-.-");
                hm.put("L", ".-..");
                hm.put("M", "--");
                hm.put("N", "-.");
                hm.put("O", "---");
                hm.put("P", ".--.");
                hm.put("Q", "--.-");
                hm.put("R", ".-.");
                hm.put("S", "...");
                hm.put("T", "-");
                hm.put("U", "..-");
                hm.put("V", "...-");
                hm.put("W", ".--");
                hm.put("X", "-..-");
                hm.put("Y", "-.--");
                hm.put("Z", "--..");
                hm.put(" ", "/");
                for (String k: hm.keySet()) {
                        hmd.put(hm.get(k), k);
                }
        }

        public String encode(String s) {
                StringBuilder sb = new StringBuilder();
                for (char c: s.toCharArray()) {
                        sb.append(hm.get(String.valueOf(c)));
                }
                return sb.toString();
        }

        public List<String> decode(String s) {
                if (s == null || s.length() == 0) {
                        return null;
                }
                List<String> ret = new ArrayList<>();
                String list = "";
                enumerate(s, ret, list, 0);
                return ret;
        }

        public void enumerate(String s, List<String> ret, String decode, int start) {
                if (start == s.length()) {
                        ret.add(new String(decode));
                        return;
                } 
                for (int i = start; i < s.length(); i++) {
                        if (hmd.containsKey(s.substring(start, i + 1))) {
                                decode += hmd.get(s.substring(start, i + 1));
                                enumerate(s, ret, decode, i + 1);
                                decode = decode.substring(0, decode.length() - 1);
                        }                        
                }
        }
        public static void main(String[] args) {
                MorseEncodeandDecode m = new MorseEncodeandDecode();
                System.out.println(m.encode("APPLE"));
                for (String s: m.decode("---------------")) {
                        System.out.println(s);
                }
        }
}*/