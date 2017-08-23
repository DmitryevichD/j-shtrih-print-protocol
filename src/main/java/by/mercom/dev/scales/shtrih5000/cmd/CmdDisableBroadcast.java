package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdDisableBroadcast extends ScaleCommand {

    /**
     * Завершить широковещательные команды
     * @param pwd пароль администратора
     */
    public CmdDisableBroadcast(Param.Password pwd) {
        super(0x0B, 5, new Param[]{pwd}, false);
    }
}
