package Operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//op-code-BEQ, rs, rt, offset
//Machine-BEQ, rs, rt, offset
public class BeqTest {
    String bin_instr = "00010010001100010000000000100000"; //"beq", "$s0", "$s1", "32" -hex-"12310020
    //bin 00010010001100010000000000100000
    String exMnem = "beq {opcode: 000100, rs: 10000, rt: 10001, offset: 0000000000100000}";
    String bin_instr1 = "00010001101000100000000000000000"; //beq t5 v0 0x0000 hex-0x11A20000
    String exMnem1 = "beq {opcode: 000100, rs: 01101, rt: 00010, offset: 1000000000000000}";
    String bin_instr2 = "00010010000001110000000100000000"; //beq $s0 $a3 "4" hex-12070100
    String exMnem2 = "beq {opcode: 000100, rs: 10000, rt: 01110, offset: 0000000100000000";
    //    String[] valid_instr = {"beq", "$s0", "$s1", "32"}; //Format: beq, rs, rt, offset
//    String[] valid_instr1 = {"beq", "$t0", "$zero", "4"};
//    String[] valid_instr2 = {"beq", "$20", "$13", "10"}; //"beq", "$s4", "$t5", "10"
//    String[] zero_offset = {"000100", "$s1", "$s2", "000000"};
//    String[] negative_offset = {"beq", "$s1", "$s3", "-200"}; //-proj instruction said will test positive val only
//
//    String[] prof1 = {"beq", "$s0", "$a0", "0x34"}; // MC: 000100 10000 00100 0000000000110100
//
    @Test
    public void good_variable_settings1() {
        Beq beq = new Beq(bin_instr);
        assertEquals(exMnem, beq.get_mnenomic());
    }
    @Test
    public void good_variable_settings2() {
        Beq beq = new Beq(bin_instr1);
        assertEquals(exMnem1, beq.get_mnenomic());
    }
    @Test
    public void good_variable_settings3() {
        Beq beq = new Beq(bin_instr2);
        assertEquals(exMnem2, beq.get_mnenomic());
    }
}
