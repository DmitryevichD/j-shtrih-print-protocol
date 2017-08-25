package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdSetScaleTimeFormat extends ScaleCommand {

    public CmdSetScaleTimeFormat(Param.Password pwd, Param.TimeFormat tmFormat) {
        super(0x23, 6, new Param[]{pwd, tmFormat}, false);
    }
}
