package MachineCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralMachineCodeTest {
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

    String instr1 = "sub {opcode: 00, rs: 15, rt: 14, rd: 1d, shmt: 00, funct: 22}";
    String instr2 = "syscall {opcode: 00, code: 000000, funct: 0c}";
    String instr3 = "sub {opcode: 00, rs: 13, rt: 1b, rd: 09, shmt: 00, funct: 22}";
    String instr4 = "ori {opcode: 0d, rs(base): 00, rt: 13, immediate(offset): ff20}";
    String instr5 = "beq {opcode: 04, rs(base): 0b, rt: 1e, immediate(offset): 00df}";
    String instr6 = "add {opcode: 00, rs: 18, rt: 0a, rd: 01, shmt: 00, funct: 20}";
    String instr7 = "beq {opcode: 04, rs(base): 1b, rt: 0a, immediate(offset): ffae}";
    String instr8 = "beq {opcode: 04, rs(base): 02, rt: 04, immediate(offset): 0017}";
    String instr9 = "j {opcode: 02, index: 00000cd}";
    String instr10 = "sw {opcode: 2b, rs(base): 14, rt: 14, immediate(offset): 0000}";
    String instr11 = "ori {opcode: 0d, rs(base): 1a, rt: 13, immediate(offset): 00ae}";
    String instr12 = "syscall {opcode: 00, code: 000000, funct: 0c}";
    String instr13 = "slt {opcode: 00, rs: 06, rt: 1f, rd: 1c, shmt: 00, funct: 2a}";
    String instr14 = "j {opcode: 02, index: 000008c}";
    String instr15 = "beq {opcode: 04, rs(base): 13, rt: 13, immediate(offset): ffe7}";
    String instr16 = "or {opcode: 00, rs: 1e, rt: 1c, rd: 00, shmt: 00, funct: 25}";
    String instr17 = "beq {opcode: 04, rs(base): 06, rt: 09, immediate(offset): 00cd}";
    String instr18 = "addiu {opcode: 09, rs(base): 1a, rt: 07, immediate(offset): 00c3}";
    String instr19 = "and {opcode: 00, rs: 17, rt: 14, rd: 07, shmt: 00, funct: 24}";
    String instr20 = "sw {opcode: 2b, rs(base): 17, rt: 0d, immediate(offset): 0000}";
    String instr21 = "bne {opcode: 05, rs(base): 16, rt: 0b, immediate(offset): 00aa}";
    String instr22 = "and {opcode: 00, rs: 08, rt: 03, rd: 17, shmt: 00, funct: 24}";
    String instr23 = "lui {opcode: 0f, rs(base): 00, rt: 1d, immediate(offset): 0071}";
    String instr24 = "syscall {opcode: 00, code: 000000, funct: 0c}";
    String instr25 = "addiu {opcode: 09, rs(base): 0e, rt: 06, immediate(offset): 004d}";
    String instr26 = "andi {opcode: 0c, rs(base): 10, rt: 11, immediate(offset): 0039}";
    String instr27 = "sub {opcode: 00, rs: 0b, rt: 01, rd: 19, shmt: 00, funct: 22}";
    String instr28 = "add {opcode: 00, rs: 1d, rt: 1a, rd: 1a, shmt: 00, funct: 20}";
    String instr29 = "andi {opcode: 0c, rs(base): 1d, rt: 19, immediate(offset): ff27}";
    String instr30 = "syscall {opcode: 00, code: 000000, funct: 0c}";
    String instr31 = "j {opcode: 02, index: 000002e}";
    String instr32 = "lui {opcode: 0f, rs(base): 00, rt: 08, immediate(offset): 004f}";
    String instr33 = "and {opcode: 00, rs: 1c, rt: 0b, rd: 04, shmt: 00, funct: 24}";
    String instr34 = "slt {opcode: 00, rs: 1c, rt: 18, rd: 10, shmt: 00, funct: 2a}";
    String instr35 = "addiu {opcode: 09, rs(base): 0f, rt: 1e, immediate(offset): 0085}";
    String instr36 = "addiu {opcode: 09, rs(base): 07, rt: 09, immediate(offset): 00d4}";
    String instr37 = "j {opcode: 02, index: 00000ef}";
    String instr38 = "lui {opcode: 0f, rs(base): 00, rt: 03, immediate(offset): 0054}";
    String instr39 = "addiu {opcode: 09, rs(base): 18, rt: 15, immediate(offset): 00d5}";
    String instr40 = "andi {opcode: 0c, rs(base): 09, rt: 14, immediate(offset): fffe}";
    String instr41 = "andi {opcode: 0c, rs(base): 04, rt: 1d, immediate(offset): 00ea}";
    String instr42 = "add {opcode: 00, rs: 0a, rt: 00, rd: 15, shmt: 00, funct: 20}";
    String instr43 = "add {opcode: 00, rs: 08, rt: 08, rd: 04, shmt: 00, funct: 20}";
    String instr44 = "add {opcode: 00, rs: 1a, rt: 1c, rd: 14, shmt: 00, funct: 20}";
    String instr45 = "sw {opcode: 2b, rs(base): 00, rt: 0d, immediate(offset): 0000}";
    String instr46 = "add {opcode: 00, rs: 1d, rt: 04, rd: 00, shmt: 00, funct: 20}";


    @Test
    void setHex1() {
        assertEquals(instr1, gmc.hex_to_mnenomic(hex1));
    }

    @Test
    void setHex2() {
        assertEquals(instr2, gmc.hex_to_mnenomic(hex2));
    }

    @Test
    void setHex3() {
        assertEquals(instr3, gmc.hex_to_mnenomic(hex3));
    }

    @Test
    void setHex4() {
        assertEquals(instr4, gmc.hex_to_mnenomic(hex4));
    }

    @Test
    void setHex5() {
        assertEquals(instr5, gmc.hex_to_mnenomic(hex5));
    }

    @Test
    void setHex6() {
        assertEquals(instr6, gmc.hex_to_mnenomic(hex6));
    }

    @Test
    void setHex7() {
        assertEquals(instr7, gmc.hex_to_mnenomic(hex7));
    }

    @Test
    void setHex8() {
        assertEquals(instr8, gmc.hex_to_mnenomic(hex8));
    }

    @Test
    void setHex9() {
        assertEquals(instr9, gmc.hex_to_mnenomic(hex9));
    }

    @Test
    void setHex10() {
        assertEquals(instr10, gmc.hex_to_mnenomic(hex10));
    }

    @Test
    void setHex11() {
        assertEquals(instr11, gmc.hex_to_mnenomic(hex11));
    }

    @Test
    void setHex12() {
        assertEquals(instr12, gmc.hex_to_mnenomic(hex12));
    }

    @Test
    void setHex13() {
        assertEquals(instr13, gmc.hex_to_mnenomic(hex13));
    }


}