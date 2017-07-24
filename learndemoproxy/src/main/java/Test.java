import dao.IUserDao;
import dao.UserDao;

public class Test {
    public static void main(String[] arg) {
        IUserDao dao = new UserDao();
        System.out.println(dao.getClass());

        IUserDao proxy = (IUserDao) new ProxyFactory(dao).getProxyInstance();
        System.out.println(proxy.getClass());

        proxy.save();
    }
}
