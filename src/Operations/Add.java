package Operations;
import MachineCode.GeneralMachineCode;

import org.ietf.jgss.GSSName;

public class Add implements Operation {
    private final String opcode;
    private String rs;
    private String rt;
    private String rd;
    private final String shamt = "00000";
    private final String funct = "100000";


    // Convert the binary String into hex & set variables appropriately ...
    public Add(String binary)
    {
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3 || parsedInstruction.length == 4) {
            this.opcode = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[0]); //assume not signed
            this.rs = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[1]);
            this.rt = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[2]);
            this.rd = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[3]);
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String opcode = binary_instr.substring(0, 6);
            String rs = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String rd = binary_instr.substring(16, 21);

            return new String[]{opcode, rs, rt, rd};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    public String get_mnenomic()
    {
        return String.format("add {opcode: %s, rs(base): %s, rt: %s, rd: %s, shamt: %s, funct: %s}",
                opcode, rs, rt, rd, shamt, funct);
    }
    public String[] getInstruction()
    {
        String[] s = {opcode, rs, rt, rd, shamt, funct};
        return s;
    }
}
