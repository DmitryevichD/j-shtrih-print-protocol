package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Завершить Широковещание
 * Запрещает указанному устройству прием широковещательных команд и возвращает из весов счетчик
 * полученных команд и счетчик успешно выполненных команд, не очищая их. \
 * Таким образом можно получить результаты выполнения широковещательных команд неоднократно
 * до следующего включения режима широковещания.
 */
public class CmdDisableBroadcast extends ScaleCommand {

    /**
     * @param pwd пароль администратора
     */
    public CmdDisableBroadcast(Param.Password pwd) {
        super(0x0B, 5, new Param[]{pwd}, false);
    }
}
