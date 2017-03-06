package interview;

/**
 * Created by HappyWu on 2017/3/6.
 */
public class StringPermutation {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        System.out.println(start);
        permute("abcdefghijk", new StringBuffer("")); //1211 7174
//        permute2(new StringBuffer("abcdefghijk"), 0); //1558 15400
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void permute(String str, StringBuffer toPrint){
        if (str == null || str.length() == 0){
            System.out.println("The input string is null");
            return;
        }

        if (str.length() == 1){
//            System.out.println(toPrint + str);
            return;
        }

        for (int i=0; i<str.length(); i++){
            StringBuffer strBuffer = new StringBuffer(str);

            //exchange str[0] and str[i]
            char temp;
            temp = strBuffer.charAt(0);
            strBuffer.setCharAt(0, strBuffer.charAt(i));
            strBuffer.setCharAt(i, temp);

            String strTemp = toPrint.toString();
            permute(strBuffer.substring(1), toPrint.append(strBuffer.charAt(0)));
            toPrint = new StringBuffer(strTemp);
        }
    }

    public static void permute2(StringBuffer strBuffer, int index){
        if (strBuffer == null || strBuffer.length() == 0){
            System.out.println("The input string is null");
            return;
        }

        if (index == strBuffer.length()){
//            System.out.println(strBuffer);
            return;
        }

        for (int i=index; i<strBuffer.length(); i++){
            //exchange str[0] and str[i]
            char temp;
            temp = strBuffer.charAt(index);
            strBuffer.setCharAt(index, strBuffer.charAt(i));
            strBuffer.setCharAt(i, temp);

            permute2(strBuffer, index+1);

            strBuffer.setCharAt(i, strBuffer.charAt(index));
            strBuffer.setCharAt(index, temp);
        }
    }
}
