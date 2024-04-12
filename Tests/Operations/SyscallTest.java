package Operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SyscallTest {
    String expMnem = "syscall";
//    String expInst = "000000001100";
//    String bin_inst = "000000XXXXXXXXXXXXXXXXXXXX001100"; //hex-0XXXXXXC

    @Test
    public void good_variable_instr(){
        Syscall s = new Syscall();
        assertEquals(expMnem, s.get_mnenomic());
    }

}
