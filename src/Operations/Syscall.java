package Operations;

import Util.General;

public class Syscall implements Operation{
    private final String opcode = "000000";
    // private String code;
    private final String funct = "001100";

    public Syscall(){
        // may not be needed any additional parsings for syscall
    }

    @Override
    public String[] binary_parser(String binary_instr) {
        // Syscall doesn't require binary parsing
        throw new UnsupportedOperationException("Syscall does not support binary parsing.");
    }

    @Override
    public String get_mnenomic() {
        return "syscall";
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, funct};
    }

//    public Syscall(String[] cleaned_instr) {
//        if(cleaned_instr.length < 1){
//            throw new IllegalArgumentException("At least one argument expected for code");
//        }
//        // code = cleaned_instr[0]; // the argument would just be "syscall"
//    }
//    public String get_hex() {
//        return "0000000c"; // this is what he was returning everytime for some reason?
//    }
//    public String[] getInstruction()
//    {
//        return new String[]{SPECIAL, SYSCALL};
//    }
}
