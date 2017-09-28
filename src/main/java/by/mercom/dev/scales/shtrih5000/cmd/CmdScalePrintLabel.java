package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Осуществляет печать этикетки с текущими в КЭ весом / количеством, ценой, стоимостью и прочими параметрами.
 * При успешной печати (ошибка «Печать прервана / неполная печать» также считается успешной печатью,
 * но сигнализирует о возможно неправильно выбранном формате этикетки) возвращает вес или количество,
 * стоимость и тип товара, которые отражены на напечатанной этикетке,
 * что может использоваться для учета при печати этикеток с ПК.
 * Автоматического учета в КЭ при печати с ПК не производится
 */
public class CmdScalePrintLabel extends ScaleCommand {
    public CmdScalePrintLabel(Param.Password pwd) {
        super(0x41, 5, new Param[]{pwd}, true);
    }
}
