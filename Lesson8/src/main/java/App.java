import com.sbt.jvschool.rnd.proxy.CacheProxy;
import com.sbt.jvschool.rnd.services.*;


public class App {
    public static void main(String[] args) {

        CacheProxy cacheProxy = new CacheProxy(".\\temp\\");


        Service service = cacheProxy.cache(new ServiceImpl());
        service.doHardWorkOne("asd",10);
        service.doHardWorkOne("asd",10);
        service.doHardWorkOne("asd",11);
        run(new ServiceImpl());
    }

    static void run(Service service) {
        double r1 = service.doHardWorkOne("work1", 10); //считает результат
        double r2 = service.doHardWorkOne("work2", 5);  //считает результат
        double r3 = service.doHardWorkOne("work1", 10); //результат из кеша
    }
}
