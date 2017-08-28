package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Команда устанавливает номер весов, который может использоваться для идентификации КЭ по
 * интерфейсу. Номер весов может также использоваться как префикс ШК обычной этикетки
 */
public class CmdSetScaleNumber extends ScaleCommand {

    /**
     * @param pwd Пароль администратора
     * @param scaleNumber Номер весов
     */
    public CmdSetScaleNumber(Param.Password pwd, Param.ScaleNumber scaleNumber) {
        super(0x25, 6, new Param[]{pwd, scaleNumber}, false);
    }
}
