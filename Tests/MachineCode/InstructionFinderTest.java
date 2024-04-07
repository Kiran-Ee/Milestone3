package MachineCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionFinderTest {
    GeneralMachineCode gmc = new GeneralMachineCode();

    String hex1 = "02b4e822";
    String hex2 = "0000000c";
    String hex3 = "027b4822";
    String hex4 = "3413ff20";
    String hex5 = "117e00df";
    String hex6 = "030a0820";
    String hex7 = "136affae";
    String hex8 = "10440017";
    String hex9 = "080000cd";
    String hex10 = "ae940000";
    String hex11 = "375300ae";
    String hex12 = "0000000c";
    String hex13 = "00dfe02a";

    String instr1 = "sub";
    String instr2 = "syscall";
    String instr3 = "sub";
    String instr4 = "ori";
    String instr5 = "beq";
    String instr6 = "add";
    String instr7 = "beq";
    String instr8 = "beq";
    String instr9 = "j";
    String instr10 = "sw";
    String instr11 = "ori";
    String instr12 = "syscall";
    String instr13 = "slt";

    @Test
    void setHex1() {
        assertEquals(instr1, gmc.instruction_finder(hex1));
    }

    @Test
    void setHex2() {
        assertEquals(instr2, gmc.instruction_finder(hex2));
    }

    @Test
    void setHex3() {
        assertEquals(instr3, gmc.instruction_finder(hex3));
    }

    @Test
    void setHex4() {
        assertEquals(instr4, gmc.instruction_finder(hex4));
    }

    @Test
    void setHex5() {
        assertEquals(instr5, gmc.instruction_finder(hex5));
    }

    @Test
    void setHex6() {
        assertEquals(instr6, gmc.instruction_finder(hex6));
    }

    @Test
    void setHex7() {
        assertEquals(instr7, gmc.instruction_finder(hex7));
    }

    @Test
    void setHex8() {
        assertEquals(instr8, gmc.instruction_finder(hex8));
    }

    @Test
    void setHex9() {
        assertEquals(instr9, gmc.instruction_finder(hex9));
    }

    @Test
    void setHex10() {
        assertEquals(instr10, gmc.instruction_finder(hex10));
    }

    @Test
    void setHex11() {
        assertEquals(instr11, gmc.instruction_finder(hex11));
    }

    @Test
    void setHex12() {
        assertEquals(instr12, gmc.instruction_finder(hex12));
    }

    @Test
    void setHex13() {
        assertEquals(instr13, gmc.instruction_finder(hex13));
    }

}