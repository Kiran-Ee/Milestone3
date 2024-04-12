package Operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//op-code: bne, rs, rt, offset
//machine: bne, rs, rt, offset
public class BneTest {
    //    String[] valid_instr = {"bne", "$s0", "$s1", "15"}; // format: bne, rs, rt, offset cleaned instruction
//    String[] valid_inst = {"000101", "$s0", "$s1", "0x0457"}; //not sure if valid inst
//    String[] valid_instr1 = {"bne", "$zero", "$t4", "18"};
//    String[] valid_instr2 = {"bne", "$6", "$11", "12"}; //"bne", "$a2", "$t3", "12"
//    String[] neg_off = {"bne", "$t0", "$t1", "-16"};
//    String[] zero_inst = {"bne", "$0", "$zero", "0"};

    String bne_instr = "00010110000100010000000000001111"; //"bne", "$s0", "$s1", "15" - hex 1611000F
    //bin 00010110000100010000000000001111
    String exMne = "bne {opcode: 000101, rs: 10000, rt: 10001, offset: 0000000000001111}";
    String bne_instr1 = " 00010101000010010000000000010000"; //"bne", "$t0", "$t1", "16"-hex 15090010
    //bin  00010101000010010000000000010000
    String exMne1 = "bne {opcode: 000101, rs: 01000, rt: 10001, offset: 00000000000010000";

    @Test
    public void good_variable_setting1(){
        Bne bne = new Bne(bne_instr);
        assertEquals(exMne, bne.get_mnenomic());
    }
    @Test
    public void good_variable_setting2(){
        Bne bne = new Bne(bne_instr1);
        assertEquals(exMne1, bne.get_mnenomic());
    }
}
