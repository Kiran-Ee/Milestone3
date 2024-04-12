package Operations;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

// op-code: addiu, rt, rs, immediate
// machine-code: sp, rs, rt, immediate
// project says only takes positive values
public class AddiuTest {
    String bin_instr1 = "00100110111110110000000000111110"; //addiu", "$s0", "$s1", "10- -26fb003e
    //bin-00100110001100000000000000000010-hex 26300002
    //bin 00100110111110110000000000111110 for 26fb003e
    String expMnem = "addiu{opcode: 001001, rs(base): 10111, rt: 11011, immediate: 0000000000111110}";
   // String expMnem = "addiu{opcode: 001001" + "rs(base): 10111" + "rt: 11011" + "immediate: 0000000000111110}";
    String bin_instr2 = "00100101000010000000000000001010";//addiu", "$t0", "$t0", "0xA- hex-2508000A"
    //bin 00100101000010000000000000001010
    String expMnem1 = "addiu{opcode: 001001, rs(base): 01000, rt: 01000, immediate: 0000000000001010";
    //String expMnem1 = "addiu{opcode: 001001 " + "rs(base): 01000" + "rt: 01000" + "immediate: 0000000000001010";
    String bin_instr3 = "00100110111001011111111111111111"; //addiu a1 s7 0xffff -hex-26E5FFFF
    String expMnem2 = "addiu{opcode: 001001" + "rs(base): 10111" + "rt: 01011" + "immediate: 1111111111111111}";
//
//    String[] instr3 = {"addiu", "$t3", "$t2", "65535"};
//    String[] instr3_hex = {"addiu", "$t3", "$t2", "0xFFFF"};


    @Test
    public void good_variable_setting1(){
        Addiu a = new Addiu(bin_instr1);
        assertEquals(expMnem, a.get_mnenomic());
    }
    @Test
    public void good_variable_setting2(){
        Addiu a = new Addiu(bin_instr2);
        assertEquals(expMnem1, a.get_mnenomic());
    }
    @Test
    public void good_variable_setting3(){
        Addiu a = new Addiu(bin_instr3);
        assertEquals(expMnem2, a.get_mnenomic());
    }

}
