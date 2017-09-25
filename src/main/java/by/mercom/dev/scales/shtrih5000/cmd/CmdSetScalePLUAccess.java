package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdSetScalePLUAccess extends ScaleCommand {
    /**
     * Записать настройку доступа к ПЛУ
     */
    public CmdSetScalePLUAccess(Param.Password pwd, Param.PLUAccess access) {
        super(0x2F, 6, new Param[]{pwd, access}, false);
    }
}
