package Operations;

import MachineCode.GeneralMachineCode;

public class Ori implements Operation{
    private final String opcode = "001101";
    private String rs = "";
    private String rt = "";
    private String immediate = "";

    public Ori(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            this.rs = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[0]);
            this.rt = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[1]);
            this.immediate = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[2]);
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }

    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String rs = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String immediate = binary_instr.substring(16, 32);
            return new String[]{rs, rt, immediate};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String get_mnenomic() {
        return String.format("ori {opcode: %s, rs: %s, rt: %s, immediate: %s}",
                opcode, rs, rt, immediate);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, rs, rt, immediate};
    }
//    public Ori(String[] cleaned_instr)
//    {
//        rs = cleaned_instr[2];
//        rt = cleaned_instr[1];
//        immediate = cleaned_instr[3];
//    }
//
//    public String get_hex() {
//        String rs_binary = General.register_to_binary(rs);
//        String rt_binary = General.register_to_binary(rt);
//        String immediate_hex = General.immediate_to_hex(immediate, true);
//
//        String com = ORI + rs_binary + rt_binary;
//
//        int com_dec = Integer.parseInt(com,2);
//
//        String com_hex = Integer.toHexString(com_dec)+immediate_hex;
//
//        return com_hex;
//    }
//    public String[] getInstruction()
//    {
//        return new String[]{ORI, rs, rt, immediate};
//    }
}
