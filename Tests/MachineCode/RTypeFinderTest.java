package MachineCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
add x
and x
or x
slt x
sub x
 */
class RTypeFinderTest {
    GeneralMachineCode gmc = new GeneralMachineCode();
    String hex1 = "02b4e822";
    String hex2 = "027b4822";
    String hex3 = "030a0820";
    String hex4 = "00dfe02a";
    String hex5 = "03dc0025";
    String hex6 = "0103b824";

    String instr1 = "sub";
    String instr2 = "sub";
    String instr3 = "add";
    String instr4 = "slt";
    String instr5 = "or";
    String instr6 = "and";

    @Test
    void setHex1() {
        assertEquals(instr1, gmc.rType_finder(hex1));
    }
    @Test
    void setHex2() {
        assertEquals(instr2, gmc.rType_finder(hex2));
    }
    @Test
    void setHex3() {
        assertEquals(instr3, gmc.rType_finder(hex3));
    }
    @Test
    void setHex4() {
        assertEquals(instr4, gmc.rType_finder(hex4));
    }
    @Test
    void setHex5() {
        assertEquals(instr5, gmc.rType_finder(hex5));
    }
    @Test
    void setHex6() {
        assertEquals(instr6, gmc.rType_finder(hex6));
    }
}