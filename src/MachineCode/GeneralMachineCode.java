package MachineCode;

public class GeneralMachineCode {
    public String hex_to_mnenomic(String hex) {
        return null;
    }

    public String instruction_finder(String hex) {
        return null;
    }

    public String rType_finder(String hex) {
        return null;
    }

    public String instruction_factory(String hex, String op_type) {
        return null;
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
