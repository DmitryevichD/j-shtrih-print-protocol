package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdGetScalePLUAccess extends ScaleCommand {
    /**
     * Получает настройку доступа к ПЛУ в рабочем режиме весов по клавише "Код".
     */
    public CmdGetScalePLUAccess(Param.Password pwd) {
        super(0x2C, 5, new Param[]{pwd}, false);
    }

}
