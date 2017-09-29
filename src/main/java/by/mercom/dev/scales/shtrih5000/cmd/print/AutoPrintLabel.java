package by.mercom.dev.scales.shtrih5000.cmd.print;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Устанавливает вес автопечати.
 * Превышение порога этого веса при взвешивании приводит к автоматической печати этикетки.
 * Используется при автоматическом режиме печати.
 */

public class AutoPrintLabel extends ScaleCommand{

    /**
     * Создает комманду для установки веса автопечати
     * @param pwd Пароль администратора
     * @param weightLimit Порог веса который приводит к автоматической печати этикетки.
     * Используется при автоматическом режиме печати.
     */
    public AutoPrintLabel(Param.Password pwd, Param.WeightLimit weightLimit) {
        super(0x28, 7, new Param[]{pwd, weightLimit}, false);
    }
}
