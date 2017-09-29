package by.mercom.dev.scales.shtrih5000.cmd.print;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Работает с контрастностью печати
 */
public class Brightness extends ScaleCommand {

    /**
     * Создает комманду для получения текущего значения контраста печати
     * @param pwd Пароль администратора
     */
    public Brightness(Param.Password pwd) {
        super(0x48, 5, new Param[]{pwd}, false);
    }

    /**
     * Создает комманду для задания значения контраста печати
     * @param pwd Пароль администратора
     * @param brightness Яркость печати
     */
    public Brightness(Param.Password pwd, Param.Brightness brightness) {
        super(0x49, 6, new Param[]{pwd, brightness}, false);
    }


}
