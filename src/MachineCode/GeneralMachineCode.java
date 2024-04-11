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
        return null;
    }

    public String pad_binary(String binary_instr, int num_padding) {
        for (int i = 0; i < num_padding; i++) {
            binary_instr = "0" + binary_instr;
        }
        return binary_instr;
    }
}
