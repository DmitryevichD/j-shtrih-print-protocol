package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdSetScalePLUAccess extends ScaleCommand {

    /**
     * Записать настройку доступа к ПЛУ
     * @param pwd Пароль
     * @param access 0 – доступ по номеру, 1 – доступ по коду товара
     */
    public CmdSetScalePLUAccess(Param.Password pwd, Param.PLUAccess access) {
        super(0x2F, 6, new Param[]{pwd, access}, false);
    }
}
