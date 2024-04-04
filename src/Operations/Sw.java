package Operations;

import Util.General;

public class Sw implements Operation{
    private final String SW = "101011";
    private String base = "";
    private String rt = "";
    private String offset = "";


    public Sw(String[] cleaned_instr)
    {
        rt = cleaned_instr[1];
        base = cleaned_instr[3];
        offset = cleaned_instr[2];
    }
    public String get_hex() {
        String base_binary = General.register_to_binary(base);
        String rt_binary = General.register_to_binary(rt);
        String offset_hex = General.immediate_to_hex(offset, true);

        String com = SW + base_binary + rt_binary;

        int com_dec = Integer.parseInt(com,2);

        String com_hex = Integer.toHexString(com_dec) + offset_hex;

        return com_hex;
    }
    public String[] getInstruction()
    {
        return new String[]{SW, base, rt, offset};
    }
}
