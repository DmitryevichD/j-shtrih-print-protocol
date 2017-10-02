package by.mercom.dev.scales.shtrih5000.config;

public class Config {
    public static class ConfigHolder{
        public static final Config CONFIG = new Config();
    }

    /**
     * Параметр определяет минимальную денежную единицу, которая исползуется для
     * прогрузки данных весов
     * Влияет на то, будет ли умножена цена на 100, перед прогрузкой в весы
     * @return true - используются рубли и копейки, false - использются только рубли
     */
    public boolean useCops(){
        //todo : change the current value to the value from config file
        return true;
    }

    public static Config getInstance(){
        return ConfigHolder.CONFIG;
    }

}
