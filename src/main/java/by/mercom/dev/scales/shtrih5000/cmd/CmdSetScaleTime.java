package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Программирование времени
 */
public class CmdSetScaleTime extends ScaleCommand {

    public CmdSetScaleTime(Param.Password pwd, Param.ScaleTime time) {
        super(0x21, 8, new Param[]{pwd, time}, false);
    }
}
