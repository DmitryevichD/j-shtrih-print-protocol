package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Очистить базу товаров и сообщений
 *
 * Эта команда инициирует начало очистки таблиц товаров и сообщений. В
 * случае нулевого кода ошибки начинается процесс очистки, в течение которого может
 * выполняться только одна команда – Запрос текущего режима весов. По результатам
 * этой команды можно отследить, когда кончится процесс и с каким результатом.
 */
public class CmdCleanAllGoodsAndMsg extends ScaleCommand{

    /**
     * @param pwd Пароль администратора
     */
    public CmdCleanAllGoodsAndMsg(Param.Password pwd) {
        super(0x18, 5, new Param[]{pwd}, true);
    }
}
