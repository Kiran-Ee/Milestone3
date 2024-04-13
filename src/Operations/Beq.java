package Operations;

import MachineCode.GeneralMachineCode;

public class Beq implements Operation{
    GeneralMachineCode gmc = new GeneralMachineCode();
    private final String opcode = "04";
    private String rs = "";
    private String rt = "";
    private String offset = "";

    public Beq(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            String rs_temp = gmc.bin_toHexImmediate(parsedInstruction[0]);
            this.rs = gmc.pad_binary(rs_temp, 2 - rs_temp.length());

            String rt_temp = gmc.bin_toHexImmediate(parsedInstruction[1]);
            this.rt = gmc.pad_binary(rt_temp, 2 - rt_temp.length());

            String offset_temp = gmc.bin_toHexImmediate(parsedInstruction[2]);
            this.offset = gmc.pad_binary(offset_temp, 4 - offset_temp.length());
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
        return String.format("beq {opcode: %s, rs(base): %s, rt: %s, immediate(offset): %s}",
                opcode, rs, rt, offset);
    }

    @Override
    public String[] getInstruction() {
        return new String[0];
    }

//    public Beq(String[] cleaned_instr){
//      rs = cleaned_instr[1];
//      rt = cleaned_instr[2];
//      offset = cleaned_instr[3];  //!!!ASSUMING WE SEND IN AN OFFSET OF THE LABEL ALREADY!!! ... handled in "text_to_hex_instructions"
//
//    }
//    public String get_hex(){
//        String rs_binary = General.register_to_binary(rs);
//        String rt_binary = General.register_to_binary(rt);
//        String offset_hex = General.immediate_to_hex(offset, true); // not sure if this is signed*
//
//        String com = BEQ + rs_binary + rt_binary;
//
//        int com_dec = Integer.parseInt(com,2);
//
//        String com_hex = Integer.toHexString(com_dec) +offset_hex;
//
//        return com_hex;
//    }
//
//    public String[] getInstruction(){ // used to check constructor
//        String[] ins = {BEQ, rs, rt, offset};
//        return ins;
//    }
}
