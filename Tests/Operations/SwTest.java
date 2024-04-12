package Operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwTest {
    // Binary instruction for "sw", "$at", "0x0010"("$s1") - hex-AE210010
    String bin_instr1 = "10101110001000010000000000010000";
    String expMnem1 = "sw {opcode: 101011, base: 10001, rt: 00001, offset: 0000000000010000}";

    // Binary instruction for "sw", "$s2", "240"("$s2") - hex-AE5200f0
    String bin_instr2 = "10101110010100100000000011110000";
    String expMnem2 = "sw {opcode: 101011, base: 10010, rt: 01000, offset: 11110000}";

    // Binary instruction for "sw", "$a3", "0x0023"("$t7") - hex-ADE70023
    String bin_instr3 = "10101101111001110000000000100011";
    String expMnem3 = "sw {opcode: 101011, base: 01111, rt: 01110, offset: 0000000000100011}";

    @Test
    public void good_variable_instr1() {
        Sub sub = new Sub(bin_instr1);
        assertEquals(expMnem1, sub.get_mnenomic());
    }

    @Test
    public void good_variable_instr2() {
        Sub sub = new Sub(bin_instr2);
        assertEquals(expMnem2, sub.get_mnenomic());
    }

    @Test
    public void good_variable_instr13() {
        Sub sub = new Sub(bin_instr3);
        assertEquals(expMnem3, sub.get_mnenomic());
    }

}
