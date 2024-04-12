package Operations;


import MachineCode.GeneralMachineCode;


import java.util.LinkedHashMap;

public class Bne implements Operation{
    private final String opcode = "000101";
    private String rs = "";
    private String rt = "";
    private String offset = "";

    public Bne(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            this.rs = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[0], false);
            this.rt = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[1], false);
            this.offset = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[2], false);
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String rs = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String offset = binary_instr.substring(16, 32);
            return new String[]{rs, rt, offset};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String get_mnenomic() {
        return String.format("bne {opcode: %s, rs(base): %s, rt: %s, offset(imm): %s}", opcode, rs, rt, offset);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, rs, rt, offset};
    }

//    public Bne(String[] cleaned_instr)
//    {
//        rs = cleaned_instr[1];
//        rt = cleaned_instr[2];
//        offset = cleaned_instr[3]; //!!!ASSUMING WE SEND IN AN OFFSET OF THE LABEL ALREADY!!! ... handled in "text_to_hex_instructions"
//    }
//    public String[] getInstruction()
//    {
//        String[] b = {BNE, rs, rt, offset};
//        return b;
//    }
//    public String get_hex(){
//        String rs_binary = General.register_to_binary(rs);
//        String rt_binary = General.register_to_binary(rt);
//        String offset_hex = General.immediate_to_hex(offset, true);
//
//        String com = BNE + rs_binary + rt_binary;
//        //assert rs_binary != null; //should we handle this way the nulls or check with if
//
//        int com_dec = Integer.parseInt(com,2);
//
//        String com_hex = Integer.toHexString(com_dec) + offset_hex;
//
//        return com_hex;
//    }

}
