package MachineCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionFactoryTest {
    GeneralMachineCode gmc = new GeneralMachineCode();
    String[] bin1 = new String[]{"02b4e822","sub"};
    String[] bin2 = new String[]{"0000000c","syscall"};
    String[] bin3 = new String[]{"027b4822","sub"};
    String[] bin4 = new String[]{"3413ff20","ori"};
    String[] bin5 = new String[]{"117e00df","beq"};
    String[] bin6 = new String[]{"030a0820","add"};
    String[] bin7 = new String[]{"136affae","beq"};
    String[] bin8 = new String[]{"10440017","beq"};
    String[] bin9 = new String[]{"080000cd","j"};
    String[] bin10 = new String[]{"ae940000","sw"};
    String[] bin11 = new String[]{"375300ae","ori"};
    String[] bin12 = new String[]{"0000000c","syscall"};
    String[] bin13 = new String[]{"00dfe02a","slt"};
    String[] bin14 = {"24ea0001", "addiu"}; // addiu t2, a3, 0x1
    String[] bin15 = {"15555410", "bne"}; // bne t1, t2, 0xAF10
    String[] bin16 = {"3c180993", "lui"}; // lui v1, 0x999
    String[] bin17 = {"8c670001", "lw"}; // lw a2, 0x1(v1)
    String[] bin18 = {"01294024", "and"}; // and t1, t1, t2
    String[] bin19 = {"00348125", "or"}; // or a1, a2, v0
    String[] bin20 = {"bfdf5b99", "random"}; // random


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
    String instr14 = "addiu {}"; //addiu t2 a3 0x1
    String instr15 = "bne"; //bne t1, t2 0xAF10
    String instr16 = "lui"; //lui v1 0x999
    String instr17 = "lw"; //lw a2 0x1 v1
    String instr18 = "and"; //and t1 t1 t2
    String instr19 = "or"; //or a1 a2 v0
    String instr20 = "Unknown instruction"; //random
//
//    String[] bin14 = {"24ea0001", "addiu"}; // addiu t2, a3, 0x1
//    String[] bin15 = {"15555410", "bne"}; // bne t1, t2, 0xAF10
//    String[] bin16 = {"3c180993", "lui"}; // lui v1, 0x999
//    String[] bin17 = {"8c670001", "lw"}; // lw a2, 0x1(v1)
//    String[] bin18 = {"01294024", "and"}; // and t1, t1, t2
//    String[] bin19 = {"00348125", "or"}; // or a1, a2, v0
//    String[] bin20 = {"bfdf5b99", "random"}; // random

//
//    @Test
//    void setHex1() {
//        assertEquals(instr1, gmc.instruction_factory(hex1[0], hex1[1]));
//    }
//
//    @Test
//    void setHex2() {
//        assertEquals(instr2, gmc.instruction_factory(hex2[0], hex2[2]));
//    }
//
//    @Test
//    void setHex3() {
//        assertEquals(instr3, gmc.instruction_factory(hex3[0], hex3[3]));
//    }
//
//    @Test
//    void setHex4() {
//        assertEquals(instr4, gmc.instruction_factory(hex4[0], hex4[4]));
//    }
//
//    @Test
//    void setHex5() {
//        assertEquals(instr5, gmc.instruction_factory(hex5[0], hex5[5]));
//    }
//
//    @Test
//    void setHex6() {
//        assertEquals(instr6, gmc.instruction_factory(hex6[0], hex6[6]));
//    }
//
//    @Test
//    void setHex7() {
//        assertEquals(instr7, gmc.instruction_factory(hex7[0], hex7[7]));
//    }
//
//    @Test
//    void setHex8() {
//        assertEquals(instr8, gmc.instruction_factory(hex8[0], hex8[8]));
//    }
//    @Test
//    void setHex9() {
//        assertEquals(instr9, gmc.instruction_factory(hex9[0], hex9[9]));
//    }
//
//    @Test
//    void setHex10() {
//        assertEquals(instr10, gmc.instruction_factory(hex10[0], hex10[1]));
//    }
//
//    @Test
//    void setHex11() {
//        assertEquals(instr11, gmc.instruction_factory(hex11[0], hex11[1]));
//    }
//
//    @Test
//    void setHex12() {
//        assertEquals(instr12, gmc.instruction_factory(hex12[0], hex12[1]));
//    }
//
//    @Test
//    void setHex13() {
//        assertEquals(instr13, gmc.instruction_factory(hex13[0], hex13[1]));
//    }

}