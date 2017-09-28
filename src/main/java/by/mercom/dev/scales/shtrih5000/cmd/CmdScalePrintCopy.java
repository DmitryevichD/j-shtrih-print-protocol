package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Осуществляет печать копии последней напечатанной обычной или итоговой этикетки.
 */
public class CmdScalePrintCopy extends ScaleCommand {
    public CmdScalePrintCopy(Param.Password pwd) {
        super(0x43, 5, new Param[]{pwd}, true);
    }
}
