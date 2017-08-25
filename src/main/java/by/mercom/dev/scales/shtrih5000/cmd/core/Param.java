package by.mercom.dev.scales.shtrih5000.cmd.core;

import javax.swing.text.Style;
import java.text.DateFormat;
import java.util.Calendar;
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
        private SType lock;

        public KeyLock(boolean isEnabled) {
            super(new SType(isEnabled), "Блокировка / разблокировка клавиатуры");
        }
    }

    /**
     * Запись положения десятичной точки
     */
    public static class DelimPos extends Param{
        private SType position;

        public DelimPos(int position){
            super("Запись положения десятичной точки");
            if (position < 0 || position > 3){
                position = 0;
            }
            super.setParam(new SType(position));
        }
    }

    /**
     * Запись номера весов
     */
    public static class Number extends Param{
        public Number(int number) {
            super(new SType(number), "Запись номера весов");
        }
    }

    /**
     * Формат отображения даты (1 байт), диапазон: 0 – ДД ММ ГГ, 1 – ГГ ММ ДД, 2 – ММ ДД ГГ.
     */
    public static class DateFormat extends Param {
        /**
         * @param tmplt DDMMYY, YYMMDD, MMDDYY
         */
        public DateFormat(String tmplt) {
            super("Формат отображения даты");
            if(tmplt.equals("YYMMDD")){
                super.setParam(new SType(1));
            }else if(tmplt.equals("MMDDYY")){
                super.setParam((new SType(2)));
            }else{
                super.setParam(new SType(0));
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
}
