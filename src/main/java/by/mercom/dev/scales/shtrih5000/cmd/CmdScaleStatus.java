package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdScaleStatus extends ScaleCommand {

    /**
     * Запрос состояния весов
     */
    public CmdScaleStatus() {
        super(0x11, 1, null, false);
    }
}
