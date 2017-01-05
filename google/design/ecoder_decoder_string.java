package design;

public class ecoder_decoder_string {

	public static String encode(String input)
    {
            StringBuilder sb = new StringBuilder();
            int times;
            for(int i =0; i < input.length();i++)
            {
                    times =1;
                    while(i+1<input.length()&&input.charAt(i)==input.charAt(i+1))
                    {
                            times++;
                            i++;
                    }
                    sb.append(times);
                    sb.append("#");
                    sb.append(input.charAt(i));
                    
            }
            
            return sb.toString();
    }
    
    public static String decode(String input)
    {
            StringBuilder sb = new StringBuilder();
            int i =0;
    
            while(i<input.length())
            {
                    int index = input.indexOf('#',i);
                    System.out.println("#" + index);
                    int wordLength = Integer.parseInt(input.substring(i, index));
                    char word = input.charAt(index+1);
                    for(int j =0; j < wordLength;j++)
                    {
                            sb.append(word);
                    }
                    i = index+2;

                    System.out.println(sb.toString());
            }
            
            return sb.toString();
            
    }
    
    public static void main(String[] args)
    {
            String test ="aaaaaaaaaaaaaaaaabbcde";
            String en = encode(test);
            System.out.println(en);
            String de = decode(en);
            System.out.println(de);
            System.out.println(de.equalsIgnoreCase(test));
    }
}
