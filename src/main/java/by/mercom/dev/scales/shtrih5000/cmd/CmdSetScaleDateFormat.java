package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdSetScaleDateFormat extends ScaleCommand {

    public CmdSetScaleDateFormat(Param.Password pwd, Param.DateFormat dtFormat) {
        super(0x24, 6, new Param[]{pwd, dtFormat}, false);
    }
}
