package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Получает или установливает настройку режима подмотчика.
 */
public class CmdScaleUnderwinerMode extends ScaleCommand {
    /**
     * Получить настройку подмотчика
     * @param pwd Пароль администратора
     */
    public CmdScaleUnderwinerMode(Param.Password pwd) {
        super(0x4B, 5, new Param[]{pwd}, false);
    }

    /**
     * Записать настройку подмотчика
     * @param pwd Пароль администратора
     * @param mode Настройка подмотчика
     */
    public CmdScaleUnderwinerMode(Param.Password pwd, Param.UnderwinderMode mode) {
        super(0x4C, 6, new Param[]{pwd, mode}, false);
    }


}
