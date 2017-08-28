package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Возвращает состояние весового устройства – признаки автонуля, тары, успокоения и
 * фиксации веса и информацию об ошибках при подсчете веса, а также текущий вес или
 * количество товара, цену, стоимость и тип товара.
 */
public class CmdScaleStatus extends ScaleCommand {
    public CmdScaleStatus() {
        super(0x11, 1, null, false);
    }
}
