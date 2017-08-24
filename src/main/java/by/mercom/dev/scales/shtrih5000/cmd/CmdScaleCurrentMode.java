package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Запрос текущего режима весов
 *
 * Это единственная команда, которая выполняется в случае процесса
 * очистки таблиц товаров и сообщений (инициируется командой Очистить базу товаров и сообщений)
 * или таблицы накоплений (инициируется командой Обнуление накоплений).
 * По состоянию подрежима весов можно выяснить окончание и результат этих
 * процессов.
 */

public class CmdScaleCurrentMode extends ScaleCommand {
    public CmdScaleCurrentMode() {
        super(0x12, 1, null, false);
    }
}
