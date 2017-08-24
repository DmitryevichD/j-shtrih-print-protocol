package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Обнуление итогов
 *
 * Эта команда инициирует начало очистки таблицы итогов. В случае
 * Э нулевого кода ошибки начинается процесс очистки, в течение которого может
 * выполняться только одна команда – Запрос текущего режима весов. По результатам
 * этой команды можно отследить, когда кончится процесс и с каким результатом.
 */
public class CmdCleanTotal extends ScaleCommand {

    public CmdCleanTotal(Param.Password pwd) {
        super(0x19, 5, new Param[]{pwd}, true);
    }
}
