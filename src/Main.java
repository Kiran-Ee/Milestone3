//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.*;
import java.math.BigInteger;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String bin = "1111111111111111111111111111111";
        int decimalValue = Integer.parseInt(bin, 2); //interprets binary as "unsigned" but only in 32 bits
        System.out.println(decimalValue);



//        String hexString_forSureSigned = "f";
//        // String hexString_forSureSigned = "FFFFFFFF"; // .parseInt() doesn't like 2^32! bc outside signed range
//        String hexString_hopefullyUnigned = "FFFFFFFF";
//        BigInteger unsignedValue = new BigInteger(hexString_hopefullyUnigned, 16); //interprets leading "1" as unsigned!!!!
//        System.out.println(Integer.parseInt(hexString_forSureSigned, 16));
//        System.out.println(unsignedValue); // Output: 4294967295
    }
}