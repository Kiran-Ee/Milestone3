package MachineCode;

public class GeneralMachineCode {
    public String hex_to_mnenomic(String hex) {
        return null;
    }

    public String instruction_finder(String hex){
        return null;
    }

    public String rType_finder(String hex) {
        return null;
    }

    public String instruction_factory(String hex, String op_type){
        return null;
    }

    public String hex_to_binary(String hex) {
        int decimal = Integer.parseInt(hex, 16);
        String binary = Integer.toBinaryString(decimal);
        int padding = 32 - binary.length();
        StringBuilder paddedBi = new StringBuilder(binary);
        for (int i = 0; i < padding; i++) {
            paddedBi.insert(0, '0');
        }
        return paddedBi.toString();
    }
    public String pad_binary(String binary_instr, int num_pad){
        // Pad the binary instruction with leading zeros
        StringBuilder paddedBinary = new StringBuilder(binary_instr);
        while (paddedBinary.length() < num_pad) {
            paddedBinary.insert(0, '0');
        }
        return paddedBinary.toString();
    }
    public static String bin_toHexImmediate(String bin_imm, boolean signed){
        int decimal = Integer.parseInt(bin_imm, 2);

        String hex = Integer.toHexString(decimal);

        int padding = 4 - hex.length();
        StringBuilder paddedHex = new StringBuilder(hex);
        for (int i = 0; i < padding; i++) {
            paddedHex.insert(0, '0');
        }
        // Add the "0x" prefix if needed
        if (!signed) {
            paddedHex.insert(0, "0x");
        }
        return paddedHex.toString();
    }

    public String pad_binary(String binary_instr, int num_padding) {
        for (int i = 0; i < num_padding; i++) {
            binary_instr = "0" + binary_instr;
        }
        return binary_instr;
    }
}
