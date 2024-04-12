package MachineCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionFinderTest {
    GeneralMachineCode gmc = new GeneralMachineCode();

    String bin1 = "00000010101101001110100000100010";
    String bin2 = "00000000000000000000000000001100";
    String bin3 = "00000010111101110100100000100010";
    String bin4 = "00110100000100111111111100100000";
    String bin5 = "00010001011111100000000011011111";
    String bin6 = "00000000110010100000100000100000";
    String bin7 = "00010011011010101111111110101110";
    String bin8 = "00010000010001000000000000010111";
    String bin9 = "00001000000000000000000011001101";
    String bin10 = "10101111101001000000000000000000";
    String bin11 = "00110101111001010000000010101110";
    String bin12 = "00000000000000000000000000001100";
    String bin13 = "00000000110111111110000000101010";

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
    void setBin1() {
        assertEquals(instr1, gmc.instruction_finder(bin1));
    }

    @Test
    void setBin2() {
        assertEquals(instr2, gmc.instruction_finder(bin2));
    }

    @Test
    void setBin3() {
        assertEquals(instr3, gmc.instruction_finder(bin3));
    }

    @Test
    void setBin4() {
        assertEquals(instr4, gmc.instruction_finder(bin4));

    }
    @Test
    void setBin5() {
        assertEquals(instr5, gmc.instruction_finder(bin5));
    }

    @Test
    void setBin6() {
        assertEquals(instr6, gmc.instruction_finder(bin6));
    }

    @Test
    void setBin7() {
        assertEquals(instr7, gmc.instruction_finder(bin7));
    }

    @Test
    void setBin8() {
        assertEquals(instr8, gmc.instruction_finder(bin8));
    }

    @Test
    void setBin9() {
        assertEquals(instr9, gmc.instruction_finder(bin9));
    }

    @Test
    void setBin10() {
        assertEquals(instr10, gmc.instruction_finder(bin10));
    }

    @Test
    void setBin11() {
        assertEquals(instr11, gmc.instruction_finder(bin11));
    }

    @Test
    void setBin12() {
        assertEquals(instr12, gmc.instruction_finder(bin12));
    }

    @Test
    void setBin13() {
        assertEquals(instr13, gmc.instruction_finder(bin13));
    }
}