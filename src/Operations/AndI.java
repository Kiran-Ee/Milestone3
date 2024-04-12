package Operations;



public class AndI implements Operation{
    private final String opcode = "001100";
    private String rs = "";
    private String rt = "";
    private String immediate = "";

    public AndI(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            this.rs = parsedInstruction[0];
            this.rt = parsedInstruction[1];
            this.immediate = parsedInstruction[2];
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
        return String.format("andi {opcode: %s, rs: %s, rt: %s, immediate: %s}",
                opcode, rs, rt, immediate);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, rs, rt, immediate};
    }

//    public AndI(String[] cleaned_instr)
//    {
//        rs = cleaned_instr[2];
//        rt = cleaned_instr[1];
//        immediate = cleaned_instr[3];
//    }
//    public String get_hex()
//    {
//        String rs_binary = General.register_to_binary(rs);
//        String rt_binary = General.register_to_binary(rt);
//        String immediate_hex = General.immediate_to_hex(immediate, true);
//
//        String com = ANDI + rs_binary + rt_binary ;
//
//        int com_dec = Integer.parseInt(com,2);
//
//        String com_hex = Integer.toHexString(com_dec) + immediate_hex;
//
//        return com_hex;
//    }
//
//    public String[] getInstruction()
//    {
//        String[] s = {ANDI, rs, rt, immediate};
//        return s;
//    }
}
