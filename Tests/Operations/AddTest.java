package Operations;

import org.junit.Test;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

// op-code: add, rd, rs, rt
// machine-code: sp, rs, rt, rd, 0, add
public class AddTest {
    String hex_instr1 = "022F802"; // "add", "$s0", "$s1", "$t7"  --at least 3 of each- random -test $a0 or $5
    String expMnem = "add{opcode: ," + "rs: " + "rt "+ "rd" +"}";
    String instr2 = "01084020"; //"add", "$t0", "$t0", "$t0"

//    String[] instr3 = {"add", "$t3", "$t2", "$t1"};
//
//    String[] instr4 = {"add", "$3", "$2", "$1"};

    // Testing the variables set up correctly
    @Test
    public void good_variable_setting1() { // "add", "$s0", "$s1", "t7"
        Add a = new Add(hex_instr1);
        assertEquals(expMnem, a.get_mnenomic());
    }
    @Test
    public void good_variable_setting2() { //"add", "$t0", "$t0", "$t0"
        Add a = new Add(hex_instr1);
        assertEquals(expMnem, a.get_mnenomic());
    }

//    // insert good_variable_setting for instr2 & instr3
//
//    @Test
//    void good_variable_setting2() {
//        Add a = new Add(instr2);
//        assertEquals(a.getInstruction()[1], instr2[2]); // rs = rs
//        assertEquals(a.getInstruction()[2], instr2[3]); // rt = rt
//        assertEquals(a.getInstruction()[3], instr2[1]); // rd = rd
//    }
//
//    @Test
//    void good_variable_setting3() {
//        Add a = new Add(instr3);
//        assertEquals(a.getInstruction()[1], instr3[2]); // rs = rs
//        assertEquals(a.getInstruction()[2], instr3[3]); // rt = rt
//        assertEquals(a.getInstruction()[3], instr3[1]); // rd = rd
//    }
//
//
//    @Test
//    void good_variable_setting4() {
//        Add a = new Add(instr4);
//        assertEquals(a.getInstruction()[1], instr4[2]); // rs = rs
//        assertEquals(a.getInstruction()[2], instr4[3]); // rt = rt
//        assertEquals(a.getInstruction()[3], instr4[1]); // rd = rd
//    }

} //end: class addTest