package MachineCode;

import Operations.*;

import java.math.BigInteger;

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

    public static String bin_toHexImmediate(String bin_imm) {
        int padding = 4 - (bin_imm.length() % 4);
        if (padding != 4) // Ensure the length of the binary string is a multiple of 4 by padding with leading zeros
            bin_imm = "0".repeat(padding) + bin_imm;


        String hexBuilder = "";

        for (int i = 0; i < bin_imm.length(); i += 4) {
            String group = bin_imm.substring(i, i + 4);

            BigInteger dec_unsigned = new BigInteger(group, 2);

            hexBuilder+= dec_unsigned.toString(16);
        }

        return hexBuilder.toLowerCase();

        // JAVA's METHOD ASSUMES SINGED BUT WE NEED IT TO WORK FOR UNSIGNED ... THE 'literal" TRANSFORMATION FROM BIN TO HEX!
//        int decimal = Integer.parseInt(bin_imm, 2);
//
//        String hex = Integer.toHexString(decimal);
//
//        int padding = 8 - hex.length();
//        hex = pad_binary(hex, padding);
//
//        return hex;
    }

    public static String pad_binary(String binary_instr, int num_padding) {
        for (int i = 0; i < num_padding; i++) {
            binary_instr = "0" + binary_instr;
        }
        return binary_instr;
    }
}
