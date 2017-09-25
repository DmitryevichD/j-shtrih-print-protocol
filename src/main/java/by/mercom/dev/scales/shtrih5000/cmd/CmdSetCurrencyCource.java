package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * УстановитьКурсВалюты
 * Устанавливает курс валюты в КЭ, который может использоваться при автоматическом
 * подсчете валютного эквивалента стоимости.
 */
public class CmdSetCurrencyCource extends ScaleCommand {
    CmdSetCurrencyCource(Param.Password pwd, Param.Cource cource) {
        super(0x2B, 9, new Param[]{pwd, cource}, false);
    }
}
