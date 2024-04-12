package Operations;

import MachineCode.GeneralMachineCode;


public class Lw implements Operation {
    private final String opcode = "100011";
    private String base = "";
    private String rt = "";
    private String offset = "";

    /*
    Format:
LW rt, offset(base)
["lw","rt","offset(base)"]
 Machine Code Format:
    [LW(6: 100011), base(5), rt(5), offset(16)]
Desc: rt <--memory[base+offset]
     */
    public Lw(String binary) {
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            this.base = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[0]);
            this.rt = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[1]);
            this.offset = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[2]); // Signed immediate
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }

    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String base = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String offset = binary_instr.substring(16, 32);
            return new String[]{base, rt, offset};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String get_mnenomic() {
        return String.format("lw {opcode: %s, base: %s, rt: %s, offset: %s}", opcode, base, rt, offset);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, base, rt, offset};
    }

//    public Lw(String[] cleaned_instr) {
//        rt = cleaned_instr[1];
//        base = cleaned_instr[3];
//        offset = cleaned_instr[2];
//    }
//
//    public String get_hex() {
//        String base_binary = General.register_to_binary(base);
//        String rt_binary = General.register_to_binary(rt);
//        String offset_hex = General.immediate_to_hex(offset, true); // assuming signed*
//
//        String com = LW + base_binary + rt_binary;
//
//        int com_dec = Integer.parseInt(com, 2);
//
//        String com_hex = Integer.toHexString(com_dec) + offset_hex;
//
//        return com_hex;
//    }
//
//    public String[] getInstruction() {
//        String[] inst = {LW, base, rt, offset};
//        return inst;
//    }
}
