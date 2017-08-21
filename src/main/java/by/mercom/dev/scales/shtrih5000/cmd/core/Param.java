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
        private byte keyCode;
        public KeyCode(byte keyCode){
            super("Код клавиши");
            this.keyCode = keyCode;
        }

        public byte[] asByteArray() {
            return new byte[]{keyCode};
        }
    }

    /**
     *  Пароль администратора (4 байта)
     *  ASCII коды цифр 0..9
     */
    public static class Password extends Param{
        private byte[] pwd;
        public Password(String pwd) {
            super("Пароль администратора");
            this.pwd = pwd.getBytes();
        }
        public byte[] asByteArray() {
            return pwd;
        }
    }

    /**
     * Блокировка / разблокировка клавиатуры
     * Значение (1 байт): 0 – разблокировать, 1 – заблокировать.
     */
    public static class KeyLock extends Param{
        private boolean isEnabled;

        public KeyLock(boolean isEnabled) {
            super("Блокировка / разблокировка клавиатуры");
            this.isEnabled = isEnabled;
        }

        public byte[] asByteArray() {
            return isEnabled ? new byte[]{1} : new byte[]{0};
        }
    }
}
