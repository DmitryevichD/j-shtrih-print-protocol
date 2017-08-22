package by.mercom.dev.scales.shtrih5000.cmd.core;

public enum ScaleKeyboard {
    /**
     * Дата/Время
     */
    KEY_DATE_TIME(0x17),

    /**
     * Курс/Экв
     */
    KEY_KURS_EKV(0x0A),

    /**
     * Регистр
     */
    KEY_REGISTR(0x09),

    /**
     * Отмена
     */
    KEY_CANCEL(0x05),

    /**
     * Код
     */
    KEY_CODE(0x0C),

    /**
     * Авто
     */
    KEY_AUTO(0x18),

    /**
     * Шт/Цена
     */
    KEY_PC_PRICE(0x0E),

    /**
     * Copy
     */
    KEY_COPY(0x0D),

    /**
     * Прокрутка
     */
    KEY_SCROLLING(0x08),

    /**
     * Печать
     */
    KEY_PRINT(0x0B),

    /**
     * Стрелка влево
     */
    KEY_LEFT(0x03),

    /**
     * Стрелка вправо
     */
    KEY_RIGHT(0x04),

    /**
     * Стрелка вверх
     */
    KEY_UP(0x06),

    /**
     * Стрелка вниз
     */
    KEY_DOWN(0x07),

    /**
     * Ввод
     */
    KEY_ENTER(0x01),

    /**
     * C
     */
    KEY_C(0x02),

    /**
     * 00
     */
    KEY_00(0x19),

    /**
     * >0<
     */
    KEY__0__(0x12),

    /**
     * >T<
     */
    KEY__T__(0x13),

    /**
     * Шт
     */
    KEY_PC(0x0F),

    /**
     * Запись
     */
    KEY_RECORD(0x16),

    /**
     * П+
     */
    KEY_P_PLUS(0x15),

    /**
     * П-
     */
    KEY_P_MINUS(0x14),

    /**
     * Сдача
     */
    KEY_SURRENDER(0x11),

    /**
     * Итог
     */
    TOTAL(0x10),

    /**
     * Клавиши быстрого доступа N 1..90
     */
    HOT_KEYS(0x80);

    private int code;
    private int hot_key = 1;

    private ScaleKeyboard(int code) {
        this.code = code;
    }


    public int getCode(){
        return code == 0x80 ? code + hot_key - 1 : code;
    }

    /**
     * Устанавливает  код клавиши  на клавиатуре
     * По умолчанию  код равен 1
     * @param val
     */
    public void setHotKeys(int val) {
        this.hot_key = val;
    }
}
