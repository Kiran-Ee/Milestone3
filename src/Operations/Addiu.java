package Operations;

import MachineCode.GeneralMachineCode;


import java.util.Arrays;

public class Addiu implements Operation{
    private String opcode = "001001";
    private String rs = "";
    private String rt = "";
    private String immediate = "";

    public Addiu (String binary)
    {
//        rs = cleaned_instructions[2]; //assuming the instance variables are Strings: registers
//        rt = cleaned_instructions[1];
//        immediate = cleaned_instructions[3];
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            this.rs = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[0], false);
            this.rt = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[1], false);
            this.immediate = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[2] + parsedInstruction[3], false);
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }
    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String rs = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String imm = binary_instr.substring(16, 32);
            return new String[]{rs, rt, imm};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }
    @Override
    public String get_mnenomic() {
        return String.format("addiu {opcode: %s, rs(base): %s, rt: %s, immediate: %s}",
                opcode, rs, rt, immediate);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, rs, rt, immediate};
    }
//    public String get_hex()
//    {
//        String rs_binary = General.register_to_binary(rs);
//        String rt_binary = General.register_to_binary(rt);
//        String immediate_hex = General.immediate_to_hex(immediate, false);
//
//        String com = ADDIU + rs_binary + rt_binary;
//
//        int com_dec = Integer.parseInt(com,2);
//
//        String com_hex = Integer.toHexString(com_dec) + immediate_hex;
//
//        return com_hex;
//    }
//
//    @Override
//    public String get_mnenomic() {
//        return String.format("addiu {opcode: %s, rs: %s, rt: %s, immediate: %s}",
//                opcode, rs, rt, immediate);
//
//    }
//
//    public String[] getInstruction()
//    {
//        return new String[]{opcode, rs, rt, immediate};
//    }
}
