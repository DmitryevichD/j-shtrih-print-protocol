package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Устанавливает указанную цену в КЭ. Не имеет значения, выбран ли товар, или нет.
 * Таким образом можно изменить цену товара на время работы с ним, не включая это изменение в
 * товарную базу
 */
public class CmdSetScalePrice extends ScaleCommand {

    /**
     * @param pwd Пароль
     * @param price Цена (4 байта), в МДЕ, диапазон: 0..999999
     */
    public CmdSetScalePrice(Param.Password pwd, Param.Price price){
        super(0x33, 9, new Param[]{pwd, price}, false);
    }
}
