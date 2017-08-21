package by.mercom.dev.scales.shtrih5000.cmd.core;

import by.mercom.dev.scales.shtrih5000.scaleException.IncorrectCommandLengthException;
import org.apache.commons.lang.ArrayUtils;

public abstract class ScaleCommand {
    private byte cmdCode;
    private byte cmdSize;
    private boolean isSyncMode;
    private String description = null;
    private Param[] params;

    private boolean isSyncMode(){
        return isSyncMode;
    }
    private byte[] paramsAsByteArray(){
        byte[] paramsArray = ArrayUtils.isNotEmpty(params) ? params[0].asByteArray() : null;

        for (int i = 1; i < params.length; i++) {
            ArrayUtils.addAll(paramsArray, params[0].asByteArray());
        }
        return paramsArray;
    }

    public ScaleCommand(int cmdCode, int cmdSize, Param[] params, boolean isSyncMode){
        this.cmdCode = (byte)cmdCode;
        this.cmdSize = (byte)cmdSize;
        this.isSyncMode = isSyncMode;
        this.params = params;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Возвращает начальный бит сообщения, в зависимости от режима, который поддерживает команда
     * @return начальный бит команды согласно спеки
     */
    private byte getCmdMode(){
        return isSyncMode() ? MODE.SYNC.getCode() : MODE.BROADCAST.getCode();
    }

    /**
     * Преобразовывает сообщение в последовательность байт, которые будут передаваться устройству
     * @return
     */
    public byte[] cmdAsByteArray() throws IncorrectCommandLengthException {
        byte[] result = ArrayUtils.addAll(new byte[]{getCmdMode(), cmdSize, cmdCode}, paramsAsByteArray());
        if (result.length != cmdSize + 2) {
            throw new IncorrectCommandLengthException("CMD:" + cmdCode + "current length: " + result.length + 2 + "needed: " + cmdSize + 2);
        }
        return result;
    }

    @Override
    public String toString(){
        return description == null ? super.toString() : description;
    }


    /**
     * Признак начала сообщения
     * Определяет начало сообщения и его режим (обычный или режим синхронизации с хостом)
     */
    enum MODE{
        BROADCAST((byte) 0x02), SYNC((byte) 0x03);

        private byte code;

        private MODE(byte code){
            this.code = code;
        }

        public byte getCode(){
          return code;
        }
    }

}
