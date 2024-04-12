package Operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LuiTest {
    //    String[] instr = {"lui", "$t0", "5"}; //format LUI, rt. immediate
//    String[] instr1 = {"lui", "$s1", "4096"};
//    String[] instr2 = {"lui", "$16", "10"}; //"lui", "$t6", "10"
//    String[] instr_zero_imm = {"lui", "$t2", "0"};
//    String[] instr_zero = {"lui", "$zero", "0"};
//    String[] neg_imm = {"lui", "$a0", "-1"}; //load upper 16 bits of the register with a dec value -1

    String bin_instr = "00111100000010000000000000000101"; //lui", "$t0", "5" - hex-3C080005
    //bin 00111100000010000000000000000101
    String exMem = "lui{opcode: 001111, rt: 01000, immediate: 0000000000000101}";
    String bin_instr1 = "00111100000100010000000000000000"; //lui", "$s1", "0" - hex-3C110000
    //bin 00111100000100010000000000000000
    String exMem1 = "lui{opcode: 001111, rt: 00010, immediate: 0000000000000000";
    String bin_instr2 = "00111100000110010000000000001010"; //lui", "$t9", "10" - hex-3C19000A
    //bin 00111100000110010000000000001010
    String exMem2 = "lui{opcode: 001111, rt: 00011, immediate: 0000000000001010";

    @Test
    public void good_variable_setting1(){
        Lui lui = new Lui(bin_instr);
        assertEquals(exMem, lui.get_mnenomic());
    }
    @Test
    public void good_variable_setting2(){
        Lui lui = new Lui(bin_instr1);
        assertEquals(exMem1, lui.get_mnenomic());
    }
    @Test
    public void good_variable_setting3(){
        Lui lui = new Lui(bin_instr2);
        assertEquals(exMem2, lui.get_mnenomic());
    }
}
