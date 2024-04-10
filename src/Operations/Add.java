package Operations;

import Util.General;
import org.ietf.jgss.GSSName;

public class Add implements Operation {
    private final String SPECIAL = "000000";
    private String rs = "";
    private String rt = "";
    private String rd = "";
    private final String ZERO = "00000";
    private final String FUNC = "100000";


    // Convert the binary String into hex & set variables appropriately ...
    public Add(String binary)
    {
        // TODO
    }

    public String get_mnenomic()
    {
        // TODO
       return null;
    }

    public String[] getInstruction()
    {
        String[] s = {SPECIAL, rs, rt, rd, ZERO, FUNC};
        return s;
    }
}
