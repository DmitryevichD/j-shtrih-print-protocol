package by.mercom.dev.scales.shtrih5000.cmd.core;

/**
 *
 * Все числовые величины передаются в двоичном формате, если не указано другое. Первым
 * передается самый младший байт, последним самый старший байт (т.н. little endian – стиль остроконечников).
 */
public abstract class Param{
    private String description;

    public Param(String description) {
        this.description = description;
    }

    public Param(){}

    public abstract byte[] asByteArray();

    /**
     * Код клавиши (1 байт)
     * См. спецификацию (Приложение 1.)
     */
    public static class KeyCode extends Param{
        private SType keyCode;
        public KeyCode(ScaleKeyboard keyCode){
            super("Код клавиши");
            this.keyCode = keyCode.getCode();
        }

        public byte[] asByteArray() {
            return keyCode.asByteArray();
        }
    }

    /**
     *  Пароль администратора (4 байта)
     *  ASCII коды цифр 0..9
     */
    public static class Password extends Param{
        private SType pwd;
        public Password(char[] pwd) {
            super("Пароль администратора");
            this.pwd = new SType(pwd);
        }
        public byte[] asByteArray() {
            return pwd.asByteArray();
        }
    }

    /**
     * Блокировка / разблокировка клавиатуры
     * Значение (1 байт): 0 – разблокировать, 1 – заблокировать.
     */
    public static class KeyLock extends Param{
        private SType lock;

        public KeyLock(boolean isEnabled) {
            super("Блокировка / разблокировка клавиатуры");
            lock = new SType(isEnabled);
        }

        public byte[] asByteArray() {
            return lock.asByteArray();
        }
    }
}
