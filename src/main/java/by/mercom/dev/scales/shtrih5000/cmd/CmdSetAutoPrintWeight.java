package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Устанавливает вес автопечати. Превышение порога этого веса
 * при взвешивании приводит к автоматической печати этикетки.
 * Используется при автоматическом режиме печати.
 * @see by.mercom.dev.scales.shtrih5000.cmd.CmdSetPrintMode
 */

public class CmdSetAutoPrintWeight extends ScaleCommand{

    /**
     * @param pwd Пароль администратора
     * @param weightLimit Предел веса, при котором будет печататься этикетка
     */
    public CmdSetAutoPrintWeight(Param.Password pwd, Param.WeightLimit weightLimit) {
        super(0x28, 7, new Param[]{pwd, weightLimit}, false);
    }
}
