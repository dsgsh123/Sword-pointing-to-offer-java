/**
 * 1.2 懒汉单例模式
 */
public class Test01_2 {

    private static  Test01_2 instance = null;

    private Test01_2(){};

    public synchronized static Test01_2 getInstance(){
        if(null == instance){
            instance = new Test01_2();
        }
        return instance;
    }

}
