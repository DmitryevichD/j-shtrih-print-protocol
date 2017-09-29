package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Получает или установливает  контраст печати.
 */
public class CmdScaleBrightness extends ScaleCommand {
    /**
     * Получает установленный в КЭ контраст печати.
     * @param pwd Пароль администратора
     */
    public CmdScaleBrightness(Param.Password pwd) {
        super(0x48, 5, new Param[]{pwd}, false);
    }

    /**
     * Устанавливает в КЭ контраст печати.
     * @param pwd Пароль администратора
     * @param brightness Яркость печати (1 байт) диапазон: 0, 1..8..15
     *               соответствует якрости НОРМ,МИН..НОРМ..МАКС соответственно
     */
    public CmdScaleBrightness(Param.Password pwd, Param.Brightness brightness) {
        super(0x49, 6, new Param[]{pwd, brightness}, false);
    }


}
