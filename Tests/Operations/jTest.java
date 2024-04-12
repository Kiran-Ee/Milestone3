package Operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Format: J target
//Machine: J, instr_index(26)
public class jTest {
    //    String[] instr = {"j", "2500"}; //format: j, target
//    String[] instr_hex = {"j", "0x1F4"};

    String bin_instr = "00001000000000000000000111110100"; //"j", "0x1F4, hex-080001F4
    String exMnem = "j {opcode: 000010, address: 00000000000000000001000000010100";

    @Test
    public void good_variable_setting1(){
        j ju = new j(bin_instr);
        assertEquals(exMnem, ju.get_mnenomic());
    }
}
