package Operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//Format: ORI rt, rs, immediate
//machine: ORI rs rt immediate
public class OriTest {
    // Binary instruction for "ori", "$t1", "$s1", "0x12" - hex-36290012
    String bin_instr1 = "00110110001010010000000000010010";
    String expMnem1 ="ori {opcode: 001101, rs: 10010, rt: 10001, immediate: 00000000000000010010";
    // Binary instruction for "ori", "$s2", "$s3", "0xFF" - hex-367200FF
    String bin_instr2 = "00110110011100100000000011111111";
    String expMnem2 = "ori {opcode: 001101, rs: 10011, rt: 10010, immediate: 00000000000011111111}";
    // Binary instruction for "ori", "$a3", "$t9", "9" - hex-37270009
    String bin_instr3 = "00110111001001110000000000001001";
    String expMnem3 = "ori {opcode: 001101, rs: 01001, rt: 11100, immediate: 00000000000000001001}";

    @Test
    public void good_variable_setting1(){
        Lw l = new Lw(bin_instr1);
        assertEquals(expMnem1, l.get_mnenomic());

    }
    @Test
    public void good_variable_setting2(){
        Lw l = new Lw(bin_instr2);
        assertEquals(expMnem2, l.get_mnenomic());
    }
    @Test
    public void good_variable_setting3(){
        Lw l = new Lw(bin_instr3);
        assertEquals(expMnem3, l.get_mnenomic());
    }


}
