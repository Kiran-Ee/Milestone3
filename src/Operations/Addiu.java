package Operations;

import MachineCode.GeneralMachineCode;


import java.util.Arrays;

public class Addiu implements Operation{
    GeneralMachineCode gmc = new GeneralMachineCode();
    private String opcode = "09";
    private String rs = "";
    private String rt = "";
    private String offset = "";

    public Addiu (String binary)
    {
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
            String imm = binary_instr.substring(16, 32);
            return new String[]{rs, rt, imm};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }
    @Override
    public String get_mnenomic() {
        return String.format("addiu {opcode: %s, rs(base): %s, rt: %s, immediate(offset): %s}",
                opcode, rs, rt, offset);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, rs, rt, offset};
    }
}
