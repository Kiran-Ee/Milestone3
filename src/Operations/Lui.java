package Operations;

import MachineCode.GeneralMachineCode;


public class Lui implements Operation{
    private final String opcode = "001111";
    private final String shamt = "00000";
    private String rt = "";
    private String immediate = "";

    public Lui(String binary) {
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 2) {
            this.rt = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[0]);
            this.immediate = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[1]);
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }

    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String rt = binary_instr.substring(6, 11);
            String immediate = binary_instr.substring(16, 32);
            return new String[]{rt, immediate};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String get_mnenomic() {
        return String.format("lui {opcode: %s, shamt(base): %s, rt: %s, immediate(offset): %s}", opcode, rt, immediate);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, shamt, rt, immediate};
    }

//    public Lui(String[] cleaned_instr)
//    {
//        rt = cleaned_instr[1];
//        immediate = cleaned_instr[2];
//    }
//
//    public String get_hex(){
//        String rt_binary = General.register_to_binary(rt);
//        String immediate_hex = General.immediate_to_hex(immediate, true);
//
//        String com = LUI + ZERO + rt_binary;
//
//        int com_dec = Integer.parseInt(com,2);
//
//        String com_hex = Integer.toHexString(com_dec) + immediate_hex;
//
//        return com_hex;
//    }
//    public String[] getInstruction()
//    {
//        return new String[]{LUI, ZERO, rt, immediate};
//    }
}
