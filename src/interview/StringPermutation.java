package interview;

/**
 * Created by HappyWu on 2017/3/6.
 */
public class StringPermutation {
    public static void main(String[] args){
        permute("abcd", "");
    }

    public static void permute(String str, String toPrint){
        if (str == null || str.length() == 0){
            System.out.println("The input string is null");
            return;
        }

        if (str.length() == 1){
            System.out.println(toPrint + str);
            return;
        }

        for (int i=0; i<str.length(); i++){
            StringBuffer strBuffer = new StringBuffer(str);

            //exchange str[0] and str[i]
            char temp;
            temp = strBuffer.charAt(0);
            strBuffer.setCharAt(0, strBuffer.charAt(i));
            strBuffer.setCharAt(i, temp);

            permute(strBuffer.substring(1), toPrint + strBuffer.charAt(0));
        }
    }
}
