//swap nums ----v easy----

import java.util.*;
public class main5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int swapNum = ((num&0x0F)<<4|(num&0xF0)>>4);
        sc.close();
    }
}
