package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Осуществляет печать тестовой этикетки. Служит для проверки качества печати.
 */
public class CmdScalePrintTestLabel extends ScaleCommand {
    public CmdScalePrintTestLabel(Param.Password pwd) {
        super(0x44, 5, new Param[]{pwd}, true);
    }
}
