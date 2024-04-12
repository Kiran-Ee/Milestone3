package Operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubTest {
    // Binary instruction for "sub", "$s1", "$s2", "$s3" - hex-02538822
    String bin_instr1 = "00000010010100111000100000100010";
    String expMnem1 = "sub {opcode: 000000, rs: 10010, rt: 10010, rd: 10001, shamt: 00000, funct: 100010}";

    // Binary instruction for "sub", "$t0", "$t1", "$t2" - hex-012A4022
    String bin_instr2 = "00000001001010100100000000100010";
    String expMnem2 = "sub {opcode: 000000, rs: 01001, rt: 01010, rd: 01000, shamt: 00000, funct: 100010}";

    // Binary instruction for "sub", "$s6", "$s7", "$a3" - hex-02E7B022
    String bin_instr3 = "00000010111001111011000000100010";
    String expMnem3 = "sub {opcode: 000000, rs: 11111, rt: 11100, rd: 11110, shamt: 00000, funct: 100010";

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
