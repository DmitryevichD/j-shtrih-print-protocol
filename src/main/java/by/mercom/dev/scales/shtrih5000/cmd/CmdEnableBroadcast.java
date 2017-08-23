package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdEnableBroadcast extends ScaleCommand {

    /**
     * Разрешить широковещательные команды
     * @param pwd пароль администратора
     */
    public CmdEnableBroadcast(Param.Password pwd) {
        super(0x0A, 5, new Param[]{pwd}, false);
    }
}
