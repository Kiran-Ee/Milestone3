package Operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LwTest {
    //    String[] instr = {"lw", "$t0", "10", "$s1"}; //Form: lw, rt, offset(base)
//    String[] instr1 = {"lw", "$0", "0", "$s0"};
//
//    String[] instr_max = {"lw", "$0", "32767", "$a0"};
//    String[] instr_invalid = {"lw", "$10", "32768", "$s0"}; // shouldn't work bc of signed range [-32768, 32767]
//
//    String[] instr_hex = {"lw", "$5", "0x9999", "$a0"};
//    String[] instr_negMin = {"lw", "$4", "-32768", "$a0"};

    String bin_instr = "10001110001010000000000000001010"; //"lw", "$t0", "10", "$s1"-hex-8E28000A
    //bin"10001110001010000000000000001010";
    String exMem = "lw{opcode: 100011, base: 01001, rt: 01000, offset: 0000000000001010}";

    String bin_instr1 = "10001100100000100000000000001010"; //"lw", "$v0", "10", "$a0"-hex-8C82000A
    //bin"10001100100000100000000000001010";
    String exMem1 = "lw{opcode: 100011, base: 01000, rt: 01000, offset: 0000000000001010}";


    @Test
    public void good_variable_setting1(){
        Lw l = new Lw(bin_instr);
        assertEquals(exMem, l.get_mnenomic());

    }
    @Test
    public void good_variable_setting2(){
        Lw l = new Lw(bin_instr1);
        assertEquals(exMem1, l.get_mnenomic());
    }
}
