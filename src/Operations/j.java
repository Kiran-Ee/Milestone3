package Operations;

import MachineCode.GeneralMachineCode;


public class j implements Operation {
    private String opcode = "000010"; //opcode for j instruction
    private String instr_index;

    public j(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 1) {
            this.instr_index = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[0]);
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String instr_index = binary_instr.substring(6, 32);
            return new String[]{instr_index};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String get_mnenomic() {
        return String.format("j {opcode: %s, instr_index(imm): %s}", opcode, instr_index);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, instr_index};
    }

//    //Constructor
//    // -	If not passed a List, not all of them are Strings, or missing values, raises illegalArgumentExceptions
//    public j(String[] cleaned_instr)
//    {
//        for (String i : cleaned_instr) {
//            if (!(i instanceof String))
//                throw new IllegalArgumentException("Can't send in non string to j operations constructor");
//        }
//        //input validation
//        if(cleaned_instr == null || cleaned_instr.length !=2){
//            throw new IllegalArgumentException("Invalid input");
//        }
//        //set instr_index from input
//        this.instr_index = cleaned_instr[1];
//    }
//    public String get_hex()
//    {
//        String instr_index_binary = General.instr_index_to_binary(instr_index, true);  // ASSUMING SIGNED*
//
//        String com_bin = j + instr_index_binary;
//
//        int com_dec = Integer.parseInt(com_bin, 2);
//
//        String com_hex = Integer.toHexString(com_dec);
//
//        com_hex = General.pad_hex(com_hex, 8);
//
//        return com_hex;
//    }
//    //get instruction format
//    public String[] getInstruction()
//    {
//        return new String[]{j, instr_index};
//    }
}

