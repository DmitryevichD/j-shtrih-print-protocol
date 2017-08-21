package by.mercom.dev.scales.shtrih5000.cmd.core;

/**
 * Данный класс представляет собой инструмент для создания и преобразования различных базовых классов java
 * в массив байтов, совместимых с протоколом Штрих-принт
 */
public class SType {
    private byte[] value;

    /**
     * Создает массив из одного байта на основании целого числа
     * @param int_val
     */
    public SType(int int_val){
        this.value = new byte[1];
        this.value[0] = (int_val < 0 || int_val > 255) ?  0 : (byte) int_val;
    }

    /**
     * Все числовые величины передаются в двоичном формате, если не указано другое. Первым
     * передается самый младший байт, последним самый старший байт (т.н. little endian – стиль остроконечников)
     * @param int_val целое число, которое необходимо преобразовать в массив байт
     * @param countByte количество младший байтов @param value которые мы преобразуем в массив байт
     */
    public SType(int int_val, int countByte){
        countByte = (countByte < 1 || countByte > 4) ? 1 : countByte;
        value = convertToByte(int_val, countByte);
    }

    public SType(char[] charVal) {
        value = new byte[charVal.length];
        for (int i = 0, chVal = charVal.length - 1; i < value.length; i++, chVal--) {
            value[i] = (byte)charVal[chVal];
        }
    }

    public SType(boolean boolVal) {
        value = new byte[1];
        value[0] = boolVal ? (byte)1 : (byte)0;
    }

    private byte[] convertToByte(int int_val, int countByte) {
        byte[] result = new byte[countByte];
        for (int i = 0; i < countByte; i++) {
            result[i] = (byte)(int_val >> 8 * i);
        }
        return result;
    }

    public byte[] asByteArray(){
        return value;
    }
}
