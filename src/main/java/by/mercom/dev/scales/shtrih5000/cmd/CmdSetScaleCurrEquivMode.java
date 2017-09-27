package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Устанавливает или сбрасывает в КЭ признак подсчета валютного эквивалента стоимости.
 * При установленном подсчете должен быть задан курс валюты. Если стоимость посчитана
 * и не равна нулю, будет подсчитан и отображен на дисплее КЭ валютный эквивалент стоимости.
 */
public class CmdSetScaleCurrEquivMode extends ScaleCommand {

    /**
     * Установить / сбросить признак подсчета валютного эквивалента
     * @param pwd Пароль
     * @param enCurrEquiv Установить / сбросить признак подсчета валютного эквивалента
     *                    диапазон: 0 – сбросить, 1 - установить
     */
    public CmdSetScaleCurrEquivMode(Param.Password pwd, Param.EnCurrEquiv enCurrEquiv){
        super(0x36, 6, new Param[]{pwd, enCurrEquiv}, false);
    }
}
