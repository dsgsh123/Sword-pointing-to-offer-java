/**
 * 1. 饿汉单例模式
 */
public class Test01_1 {

    private static final Test01_1 instance = new Test01_1();
    private Test01_1(){};

    public static Test01_1 getInstance(){
        return instance;
    }

}
