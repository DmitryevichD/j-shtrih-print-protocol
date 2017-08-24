package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Гудок
 */
public class CmdScaleBeep extends ScaleCommand{

    public CmdScaleBeep() {
        super(0x13, 1, null, false);
    }
}
