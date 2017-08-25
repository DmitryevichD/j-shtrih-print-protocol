package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdSetScaleNumber extends ScaleCommand {

    public CmdSetScaleNumber(Param.Password pwd, Param.Number number) {
        super(0x25, 6, new Param[]{pwd, number}, false);
    }
}
