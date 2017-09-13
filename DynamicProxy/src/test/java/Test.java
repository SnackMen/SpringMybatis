import com.ws.cglib.UserCglibProxy;
import com.ws.proxy.ProxyFactory;
import com.ws.proxy.StudentBean;
import com.ws.proxy.StudentInterface;

public class Test {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        StudentBean studentBean = new StudentBean("test");

        StudentInterface studentInterface = (StudentInterface)proxyFactory.createStudentProxy(studentBean);

        studentInterface.print();

        UserCglibProxy userCglibProxy = new UserCglibProxy();
        StudentBean studentBean1 = (StudentBean)userCglibProxy.getInstance(new StudentBean());
        studentBean1.print();
    }
}
