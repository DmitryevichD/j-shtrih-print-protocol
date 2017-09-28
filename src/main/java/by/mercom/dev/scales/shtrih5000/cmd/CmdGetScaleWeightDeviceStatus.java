package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Возвращает состояние весового устройства – признаки автонуля, тары, успокоения и
 * фиксации веса и информацию об ошибках при подсчете веса, а также текущий вес или
 * количество товара, цену, стоимость и тип товара
 */
public class CmdGetScaleWeightDeviceStatus extends ScaleCommand {

    /**
     * @param pwd Пароль
     */
    public CmdGetScaleWeightDeviceStatus(Param.Password pwd){
        super(0x3A, 5, new Param[]{pwd}, false);
    }
}
