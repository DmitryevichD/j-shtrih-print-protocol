package by.mercom.dev.scales.shtrih5000.cmd.core;

import by.mercom.dev.scales.shtrih5000.scaleException.IncorrectParamValue;

import java.util.Date;

/**
 *
 * Все числовые величины передаются в двоичном формате, если не указано другое. Первым
 * передается самый младший байт, последним самый старший байт (т.н. little endian – стиль остроконечников).
 */
public abstract class Param{
    private String description;
    private SType stype;

    public Param(SType param, String description) {
        this.stype = param;
        this.description = description;
    }

    public Param(String description){
        this.description = description;
    }

    public void setParam(SType param) {
        stype = param;
    }

    public byte[] asByteArray() {
        return stype.asByteArray();
    };

    /**
     * Код клавиши (1 байт)
     * См. спецификацию (Приложение 1.)
     */
    public static class KeyCode extends Param{
        public KeyCode(ScaleKeyboard keyCode){
            super(new SType(keyCode.getCode()), "Код клавиши");
        }
    }

    /**
     *  Пароль администратора (4 байта)
     *  ASCII коды цифр 0..9
     */
    public static class Password extends Param{
        public Password(char[] pwd) {
            super(new SType(pwd), "Пароль администратора");
        }
    }

    /**
     * Блокировка / разблокировка клавиатуры
     * Значение (1 байт): 0 – разблокировать, 1 – заблокировать.
     */
    public static class KeyLock extends Param{
        public KeyLock(boolean isEnabled) {
            super(new SType(isEnabled), "Блокировка / разблокировка клавиатуры");
        }
    }

    /**
     * Запись положения десятичной точки
     */
    public static class DelimPos extends Param{
        private SType position;

        public DelimPos(int position) throws IncorrectParamValue{
            super("Запись положения десятичной точки");
            if (position >= 0 || position <= 3) {
                super.setParam(new SType(position));
            }else {
                throw new IncorrectParamValue("DelimPos.Current value=" + position + ", must be 0..3");
            }
        }
    }

    /**
     * Запись номера весов
     * Внимение. Берется младший байт типа integer
     */
    public static class ScaleNumber extends Param {
        public ScaleNumber(int scaleNumber) throws IncorrectParamValue{
            super(new SType(scaleNumber), "Запись номера весов");
        }
    }

    /**
     * Формат отображения даты
     */
    public static class DateFormat extends Param {
        /**
         * @param tmplt DDMMYY, YYMMDD, MMDDYY
         */
        public DateFormat(String tmplt) throws IncorrectParamValue{
            super("Формат отображения даты");
            if(tmplt.equals("YYMMDD")){
                super.setParam(new SType(1));
            }else if(tmplt.equals("MMDDYY")){
                super.setParam((new SType(2)));
            }else if(tmplt.equals("DDMMYY")){
                super.setParam(new SType(0));
            }else {
                throw new IncorrectParamValue("DateFormat. Current value=" + tmplt + ", must be  YYMMDD or MMDDYY or DDMMYY");
            }
        }
    }

    /**
     * Запись формата отображения времени
     * 12 часов либо 24
     */
    public static class TimeFormat extends Param{
        /**
         * Формат отображения времени (1 байт), диапазон: 0 – 12 часовой
         * формат, 1 – 24 часовой формат.
         * @param is12hr Если 12 часов true, иначе false
         */
        public TimeFormat(Boolean is12hr) {
            super("Запись формата отображения времени");
            SType format = is12hr ? new SType(0): new SType(1);
            super.setParam(format);
        }
    }

    /**
     * Дата ДД-ММ-ГГ (3 байта)
     */
    public static class ScaleDate extends Param{
        public ScaleDate(Date date) {
            super(new SType(date), "Программирование даты");
        }
    }

    /**
     * Время ЧЧ-ММ-СС (3 байта)
     */
    public static class ScaleTime extends Param{
        public ScaleTime(long time) {
            super(new SType(time), "Программирование времени");
        }
    }

    /**
     * Устанавливает режим печати
     */
    public static class PrintMode extends Param{
        /**
         *
         * @param printMode 0 – нет, 1 – разрешена, 2 - автопечать
         * @throws IncorrectParamValue - неверное значение параметра
         */
        public PrintMode(int printMode) throws IncorrectParamValue {
            super("Режим печати");
            if (printMode >= 0 || printMode <= 3) {
                super.setParam(new SType(printMode));
            }else {
                new IncorrectParamValue("WeightLimit. Current value=" + printMode + ", must be 0..2");
            }
        }
    }

    /**
     * Содержит сведения о наибольшем пределе взвешивания весов, в граммах.
     */
    public static class WeightLimit extends Param {
        /**
         * Предел взвешивания в граммах
         * @param weight о 1 грамма до 65535г
         */
        public WeightLimit(int weight) throws IncorrectParamValue{
            super("Предел взвешивания");
            if (weight >= 0 || weight <= 65535) {
                super.setParam(new SType(weight, 2));
            }else {
                throw new IncorrectParamValue("WeightLimit.Current value=" + weight + ", must be 1..65535");
            }
        }
    }

    /**
     * Режим фaсовки на весах вкл/выкл.
     */
    public static class PackMode extends Param{
        public PackMode(boolean isEnable) {
            super(new SType(isEnable), "Режим фaсовки на весах");
        }
    }

    /**
     * Режим фaсовки на весах вкл/выкл.
     */
    public static class BeepMode extends Param {
        public BeepMode(boolean isEnable){
            super(new SType(isEnable), "Режим работы звука");
        }
    }

    /**
     * Курс валюты (4 байта, дробное), диапазон:
     1. 0..999999 (положение десятичной точки = 0)
     2. 0..99999.9 (положение десятичной точки = 1)
     3. 0..9999.99 (положение десятичной точки = 2)
     */
    public static class Cource extends Param {
        public Cource(float cource) throws IncorrectParamValue {
            super("Курс валюты");
            if (cource >= 0 && cource <= 999999f) {
                super.setParam(new SType(cource));
            }else
                throw new IncorrectParamValue("Cource value=" + cource + ", must be 0..999999");

        }
    }

    /**
     * Настройка доступа к ПЛУ (1 байт), диапазон:
     * 0 – доступ по номеру
     * 1 – доступ по коду товара
     */
    public static class PLUAccess extends Param {
        private final int minVal = 0;
        private final int maxVal = 1;
        public PLUAccess(int access) throws IncorrectParamValue{
            super("Настройка доступа к ПЛУ");
            if (access >= minVal && access <= maxVal) {
                super.setParam(new SType(access));
            }else {
                throw new IncorrectParamValue("PLU access " + access + ", must be 0 or 1");
            }
        }
    }

    /**
     * Тара (2 байта), в г, диапазон: 0..НПВ/10
     */
    public static class Tare extends Param{
        public Tare(int tare){
            super(new SType(tare, 2), "Задать тару");
        }
    }

    /**
     *  Цена (4 байта), в МДЕ, диапазон: 0..999999
     */
    public static class Price extends Param {
        private final int minVal = 0;
        private final int maxVal = 999999;

        public Price(int price) throws IncorrectParamValue{
            super("Установить цену");
            if(price >= minVal && price <= maxVal){
                super.setParam(new SType(price, 4));
            }else {
                throw new IncorrectParamValue("Price value " + price + ", must be " + minVal + ".." + maxVal);
            }
        }
    }

    /**
     * Количество (1 байт), диапазон: 0..99
     */
    public static class Quantity extends Param{
        private final int minVal = 0;
        private final int maxVal = 99;

        public Quantity(int quantity) throws IncorrectParamValue{
            super("Установить количество");
            if(quantity >= minVal && quantity <= maxVal){
                super.setParam(new SType(quantity, 1));
            }else {
                throw new IncorrectParamValue("Quantity value " + quantity + ", must be " + minVal + ".." + maxVal);
            }
        }
    }

    /**
     * Тип товара (1 байт), диапазон:
     */
    public static class GoodsType extends Param{
        private final int minVal = 0;
        private final int maxVal = 1;

        /**
         *
         * @param goodsType 0 – весовой, 1 - штучный
         * @throws IncorrectParamValue
         */
        public GoodsType(int goodsType) throws IncorrectParamValue{
            super("Установить тип товара");
            if(goodsType >= minVal && goodsType <= maxVal){
                super.setParam(new SType(goodsType, 1));
            }else {
                throw new IncorrectParamValue("Goods type value " + goodsType + ", must be " + minVal + ".." + maxVal);
            }
        }
    }

    /**
     * Установить / сбросить признак подсчета валютного эквивалента
     */
    public static class EnCurrEquiv extends Param{
        /**
         * @param isEnabled диапазон: false – сбросить, true - установить
         */
        public EnCurrEquiv(boolean isEnabled){
            super(new SType(isEnabled), "Установить / сбросить признак подсчета валютного эквивалента");
        }
    }

    /**
     * Номер товара (2 байта)
     */
    public static class GoodItem extends Param {
        private final int minVal = 0;
        private final int maxVal = 65535;

        public GoodItem(int goodItem) throws IncorrectParamValue{
            super("Номер товара");
            if(goodItem >= minVal && goodItem <= maxVal){
                super.setParam(new SType(goodItem, 2));
            }else{
                throw new IncorrectParamValue("Goods item value " + goodItem + ", must be " + minVal + ".." + maxVal);
            }
        }
    }

    /**
     * Смещение печати (1 байт) диапазон: 0..7
     * соответствует смещению печати 0..-7 соответственно (единица смещения равна 0.125 мм)
     */
    public static class Offset extends Param{
        private final int minVal = 0;
        private final int maxVal = 7;

        public Offset(int offset) throws IncorrectParamValue{
            super("Смещение печати");
            if(offset >= minVal && offset <= maxVal){
                super.setParam(new SType(offset, 1));
            }else{
                throw new IncorrectParamValue("Print offset" + offset + ", must be " + minVal + ".." + maxVal);
            }
        }
    }

    /**
     * Яркость печати (1 байт) диапазон: 0, 1..8..15
     * соответствует якрости НОРМ,МИН..НОРМ..МАКС соответственно
     * */

    public static class Brightness extends Param {
        private final int minVal = 0;
        private final int maxVal = 15;

        public Brightness(int brightness) throws IncorrectParamValue {
            super("Яркость печати");
            if(brightness >= minVal && brightness <= maxVal){
                super.setParam(new SType(brightness, 1));
            }else{
                throw new IncorrectParamValue("Brightness" + brightness + ", must be " + minVal + ".." + maxVal);
            }
        }
    }

    /**
     * Настройка подмотчика (1 байт), диапазон: 0..2
     * 0 - выключен
     * 1 - обычная подмотка
     * 2 - усиленный подмотчик
     */
    public static class UnderwinderMode extends Param{
        private final int minVal = 0;
        private final int maxVal = 2;

        public UnderwinderMode(int underwinderMode) throws IncorrectParamValue {
            super("Настройки подмотчика");
            if(underwinderMode >= minVal && underwinderMode <= maxVal){
                super.setParam(new SType(underwinderMode, 1));
            }else{
                throw new IncorrectParamValue("UnderwinderMode" + underwinderMode + ", must be " + minVal + ".." + maxVal);
            }
        }
    }
}
