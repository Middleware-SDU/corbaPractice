package excise2_1;

import java.io.IOException;
import java.util.Properties;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import cn.sdu.edu.middleware.excise2_1.MyServer.MyService;
import cn.sdu.edu.middleware.excise2_1.MyServer.MyServiceHelper;

/**
 * 
 * @author Yonggang Yuan
 *
 */

public class EnvTest {

    private MyService target = null;
    private org.omg.CORBA.ORB orb = null;

    /**
     * Constructor for MyServiceClientImpl
     * 
     * @throws IOException
     */
    public EnvTest() throws IOException {
        initORB(null);
    }

    /**
     * Constructor for MyServiceClientImpl
     * 
     * @throws IOException
     * @see java.lang.Object#Object()
     */
    public EnvTest(String[] args) throws IOException {
        initORB(args);
    }

    /**
     * Initialize ORB.
     * 
     * @param args
     * @throws IOException
     */
    public void initORB(String[] args) throws IOException {

        Properties props = System.getProperties();
        props.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
        props.setProperty("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");

        // 启动参数
        props.setProperty("ORBInitRef.NameService", "corbaloc::localhost:30000/NameService");

        orb = org.omg.CORBA.ORB.init(args, props);
        // 获得命名服务上下文
        // 获得命名服务对象
        org.omg.CORBA.Object nsObj = null;
        try {
            nsObj = orb.resolve_initial_references("NameService");
        } catch (InvalidName e) {
            e.printStackTrace();
        }

        // 通过命名服务对象得到命名服务上下文
        NamingContextExt nc = NamingContextExtHelper.narrow(nsObj);
        // 从命名服务上下文中获得特定的命名服务对象
        org.omg.CORBA.Object svrObj = null;
        try {
            svrObj = nc.resolve_str("Simple.MyService");
        } catch (NotFound e) {
            e.printStackTrace();
        } catch (CannotProceed e) {
            e.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            e.printStackTrace();
        }
        // 从将特定命名服务对象中获得服务接口
        MyService service = MyServiceHelper.narrow(svrObj);
        target = service;
    }

    /**
     * Obtain ORB Interface.
     * 
     * @return
     */
    public MyService getORBInterface() {
        return target;
    }

    /**
     * Shutdown ORB.
     */
    public void shutdown() {
        orb.shutdown(true);
    }

    /**
     * Test driver for MyServiceClientImpl.
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            EnvTest test = new EnvTest();

            // test.getORBInterface().operation1("Hello,山东大学 电子商务 2011级 !");
            test.getORBInterface().operation1("Hello, I am a student of SDU");

            System.out.println("我在客户端,客户正在调用operation1()方法！!");

            test.shutdown();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
