package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Изменение пароля администратора
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
