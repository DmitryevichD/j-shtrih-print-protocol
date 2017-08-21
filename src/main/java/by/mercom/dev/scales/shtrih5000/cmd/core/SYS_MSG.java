package by.mercom.dev.scales.shtrih5000.cmd.core;

/**
 * @Author Dmitrievich D.K.
 * @Date 2017-08-18
 *
 * Данное перечисление содержит служебные сообщения для данного протокола
 */
public enum SYS_MSG {
    /**
     * Сообщение ENQ используется хостом для определения состояния переферийного устройства.
     * Данное сообщение использует только в режиме синхронизации, т.к. только в этом режиме
     * предусматривается ответ от переферийного устройства.
     *
     * Ответы:
     *
     * 1)Если периферийное устройство готово принимать новую команду, хост  посылает сообщение-команду
     * и в течение таймаута ожидает ответа, в случае его отсутствия хост проверяет состояние периферийного устройства,
     * иначе проверяет корректность ответа и отвечает периферийному устройству положительным или отрицательным
     * подтверждением – пакетами с байтами ACK или NAK соответственно, после чего вновь проверяет состояние
     * периферийного устройства запросом ENQ. Этот цикл выполняется до получения от периферийного устройства
     * ответа ACK на запрос ENQ,
     * количество повторов настраивается программным обеспечением хоста.
     * Превышение этого лимита считается отсутствием связи.
     *
     * 2)В случае, если хост получил от весов ответ на ранее выполненную команду по запросу ENQ, то если ответ
     * без признака синхронизации, хост приступает к передаче команды, иначе хост должен выслать весам
     * подтверждение ACK или NAK и проверить после этого состояние весов повторным запросом ENQ.
     * Количество запросов ENQ, не приводящих к сообщению ACK, настраиваются программным обеспечением хоста.
     * Превышение этого лимита считается отсутствием связи.
     *
     * 3)В случае, если хост получил от периферийного устройства ответ NAK, он должен выждать
     * в течение 1 с (таймаут на ожидание весами ACK) и повторить запрос.
     * Количество запросов, не приводящих к ответу ACK, настраиваются программным обеспечением хоста.
     * Превышение этого лимита считается отсутствием связи.
     */
    ENQ((byte)0x05),

    /**
     * Сообщение ACK используется хостом для подтверждения ответа на команду
     * от периферийного устройства (только в режиме синхронизации)
     * и используется периферийным устройством для информирования хоста о состоянии готовности
     * к приему новой команды по запросу ENQ.
     */
    ACK((byte)0x06),

    /**
     * Сообщение NAK используется хостом для информирования периферийного устройства
     * о неверном формате сообщения ответа на команду (только в режиме синхронизации),
     * периферийным устройством используется для информирования хоста
     о неверном формате сообщения для текущего состояния периферийного устройства.
     */
    NAK((byte)0x15),

    /**
     * В режиме синхронизации периферийное устройство может быть «захвачено» хостом, который инициировал синхронизацию,
     * но по каким-либо причинам периферийное устройство находится в состоянии ожидания подтверждения ответа на команду
     * (в течение таймаута) или в состоянии ожидания запроса на повтор ответного пакета (без таймаута).
     * В этом случае на обращение другого хоста (или с другого UDP-порта) периферийное устройство формирует
     * сообщение BUSY из семи байт:
     * Байт 0: признак захвата другим хостом BUSY
     * Байт 1: 2-ой байт IP-адреса захватившего хоста
     * Байт 2: 1-ый байт IP-адреса захватившего хоста
     * Байт 3: 4-ый байт IP-адреса захватившего хоста
     * Байт 4: 3-ий байт IP-адреса захватившего хоста
     * Байты 5..6: номер UDP-порта захватившего хоста
     */
    BUSY((byte)0x0B);

    private final byte code;

    private SYS_MSG(byte code){
        this.code = code;
    }

    public byte getCode(){ return code;}

    /**
     * Проверяет, является ли указанный код системным
     * @param code код, который необходимо проверить
     * @return true - код является системным, иначе false
     */
    public static boolean isSysCode(byte code) {
        for (SYS_MSG sys_msg : values()) {
            if (sys_msg.getCode() == code) {
                return true;
            }
        }
        return false;
    }
}
