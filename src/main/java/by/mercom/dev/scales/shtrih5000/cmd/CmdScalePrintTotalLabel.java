package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Осуществляет печать итоговой этикетки. Для этого сумматор не должен быть пуст и печать
 * итоговой этикетки должна быть разрешена.
 */
public class CmdScalePrintTotalLabel extends ScaleCommand {
    public CmdScalePrintTotalLabel(Param.Password pwd) {
        super(0x42, 5, new Param[]{pwd}, true);
    }
}
