package Operations;

import MachineCode.GeneralMachineCode;


public class Sub implements Operation {
    GeneralMachineCode gmc = new GeneralMachineCode();
    private final String opcode = "00";
    private String rs = "";
    private String rt = "";
    private String rd = "";
    private String shamt = "00";
    private String funct = "22";

    public Sub(String binary) {
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            String rs_temp = gmc.bin_toHexImmediate(parsedInstruction[0]);
            this.rs = gmc.pad_binary(rs_temp, 2 - rs_temp.length());

            String rt_temp = gmc.bin_toHexImmediate(parsedInstruction[1]);
            this.rt = gmc.pad_binary(rt_temp, 2 - rt_temp.length());

            String rd_temp = gmc.bin_toHexImmediate(parsedInstruction[2]);
            this.rd = gmc.pad_binary(rd_temp, 2 - rd_temp.length());
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }

    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String rs = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String rd = binary_instr.substring(16, 21);
            return new String[]{rs, rt, rd};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String get_mnenomic() {
        return String.format("sub {opcode: %s, rs: %s, rt: %s, rd: %s, shmt: %s, funct: %s}",
                opcode, rs, rt, rd, shamt, funct);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, rs, rt, rd, shamt, funct};
    }

//    public Sub(String[] cleaned_instr)
//    {
//        rs = cleaned_instr[2];
//        rt = cleaned_instr[3];
//        rd = cleaned_instr[1];
//    }
//    public String get_hex() {
//        String rs_binary = General.register_to_binary(rs);
//        String rt_binary = General.register_to_binary(rt);
//        String rd_binary = General.register_to_binary(rd);
//
//        String com = SPECIAL + rs_binary + rt_binary + rd_binary + ZERO + SUB;
//
//        int com_dec = Integer.parseInt(com,2); // String(Binary) -> Int(dec)
//
//        String com_hex = Integer.toHexString(com_dec); // Int(dec) -> String(hex)
//
//        com_hex = General.pad_hex(com_hex, 8); // padding
//
//        return com_hex;
//    }
//    public String[] getInstruction()
//    {
//        return new String[]{SPECIAL, rs, rt, rd, ZERO, SUB};
//    }
}
