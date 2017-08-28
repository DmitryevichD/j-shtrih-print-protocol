package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Указывает новый пароль для доступа к системному меню и связи по интерфейсу.
 */
public class CmdChangePassword extends ScaleCommand{

    /**
     * @param oldPwd Старый пароль
     * @param newPwd Новый пароль
     */
    public CmdChangePassword(Param.Password oldPwd, Param.Password newPwd) {
        super(0x16, 9, new Param[]{oldPwd, newPwd}, true);
    }
}
