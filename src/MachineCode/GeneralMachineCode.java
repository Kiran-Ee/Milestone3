package MachineCode;

import Operations.*;

public class GeneralMachineCode {
    public String hex_to_mnenomic(String hex) {
        String bin = hex_to_binary(hex);
        String op_type = instruction_finder(bin);
        return (instruction_factory(bin, op_type));
    }

    public String instruction_finder(String bin) {
        String op_code = bin.substring(0, 6);
        return switch (op_code) {
            case "000000" -> rType_finder(bin);
            case "001001" -> "addiu";
            case "000100" -> "beq";
            case "000101" -> "bne";
            case "000010" -> "j";
            case "001111" -> "lui";
            case "100011" -> "lw";
            case "001101" -> "ori";
            case "101011" -> "sw";
            default -> "Unknown instruction";
        };
    }

    // Must be called by a op_code = R type in instruction_finder
    public String rType_finder(String bin) {
        String func = bin.substring(32-6);
        return switch (func) {
            case "100000" -> "add";
            case "100100" -> "and";
            case "100101" -> "or";
            case "101010" -> "slt";
            case "100010" -> "sub";
            case "001100" -> "syscall";
            default -> "Unknown instruction";
        };
    }

    public String instruction_factory(String bin, String op_type) {
        Operation op_obj = switch (op_type) {
            case "add" -> new Add(bin);
            case "addiu" -> new Addiu(bin);
            case "and" -> new And(bin);
            case "andi" -> new AndI(bin);
            case "beq" -> new Beq(bin);
            case "bne" -> new Bne(bin);
            case "j" -> new j(bin);
            case "lui" -> new Lui(bin);
            case "lw" -> new Lw(bin);
            case "or" -> new Or(bin);
            case "ori" -> new Ori(bin);
            case "slt" -> new Slt(bin);
            case "sub" -> new Sub(bin);
            case "sw" -> new Sw(bin);
            case "syscall" -> new Syscall();
            default -> throw new IllegalArgumentException("Entered invalid operation to instruction_factory");
        };
        return op_obj.get_mnenomic();
    }

    public String hex_to_binary(String hex) {
        int decimal = Integer.parseInt(hex, 16);
        String binary = Integer.toBinaryString(decimal);
        int padding = 32 - binary.length();
        binary = pad_binary(binary, padding);
        return binary;
    }

    // TODO: this method probs needs to handle "unsigned" since java's methods automatically interpret as "signed" ... use "General"'s method bc very similar.
    public static String bin_toHexImmediate(String bin_imm) {
        int decimal = Integer.parseInt(bin_imm, 2);

        String hex = Integer.toHexString(decimal);

        int padding = 8 - hex.length();
        hex = pad_binary(hex, padding);

        return hex;
    }

    public static String pad_binary(String binary_instr, int num_padding) {
        for (int i = 0; i < num_padding; i++) {
            binary_instr = "0" + binary_instr;
        }
        return binary_instr;
    }
}
