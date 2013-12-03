package excise2_2;

import java.io.IOException;
import java.util.Properties;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService;
import cn.sdu.edu.middleware.excise2_2.daos.beans.GradeServiceHelper;
import cn.sdu.edu.middleware.excise2_2.daos.beans.Subject;
import cn.sdu.edu.middleware.excise2_2.daos.beans.SubjectService;
import cn.sdu.edu.middleware.excise2_2.daos.beans.SubjectServiceHelper;
import cn.sdu.edu.middleware.excise2_2.daos.beans.User;
import cn.sdu.edu.middleware.excise2_2.daos.beans.UserService;
import cn.sdu.edu.middleware.excise2_2.daos.beans.UserServiceHelper;

/**
 * 
 * @author Yonggang Yuan
 *
 */

public class CorbaAppTest {

    private UserService target4user = null;
    private SubjectService target4subject = null;
    private GradeService target4grade = null;
    private org.omg.CORBA.ORB orb = null;

    /**
     * Constructor for MyServiceClientImpl
     * 
     * @throws IOException
     */
    public CorbaAppTest() throws IOException {
        initORB(null);
    }

    /**
     * Constructor for MyServiceClientImpl
     * 
     * @throws IOException
     * @see java.lang.Object#Object()
     */
    public CorbaAppTest(String[] args) throws IOException {
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
        org.omg.CORBA.Object svrObj1 = null;
        org.omg.CORBA.Object svrObj2 = null;
        try {
            svrObj = nc.resolve_str("dao.UserService");
            svrObj1 = nc.resolve_str("dao.SubjectService");
            svrObj2 = nc.resolve_str("dao.GradeService");
        } catch (NotFound e) {
            e.printStackTrace();
        } catch (CannotProceed e) {
            e.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            e.printStackTrace();
        }
        // 从将特定命名服务对象中获得服务接口
        UserService service4user = UserServiceHelper.narrow(svrObj);
        target4user = service4user;

        SubjectService service4subject = SubjectServiceHelper.narrow(svrObj1);
        target4subject = service4subject;

        GradeService service4grade = GradeServiceHelper.narrow(svrObj2);
        target4grade = service4grade;
    }

    /**
     * Obtain ORB Interface.
     * 
     * @return
     */
    public UserService getORBInterface4user() {
        return target4user;
    }
    public SubjectService getORBInterface4subject() {
        return target4subject;
    }
    public GradeService getORBInterface4grade() {
        return target4grade;
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
            CorbaAppTest test = new CorbaAppTest();

            User u = new User(1, "yyg1");
            test.getORBInterface4user().save(u);
            System.out.println("插入User：yyg1");

            Subject math = new Subject(1, "Math");
            Subject english = new Subject(2, "English");
            test.getORBInterface4subject().save(math);
            System.out.println("插入Subject：Math");
            test.getORBInterface4subject().save(english);
            System.out.println("插入Subject：English");

            test.getORBInterface4grade().setGrade(1, 1, 100);
            test.getORBInterface4grade().setGrade(1, 2, 90);

            test.shutdown();

            CorbaAppTest test1 = new CorbaAppTest();
            int score4Math = test1.getORBInterface4grade().getGrade(1, 1);
            int score4English = test1.getORBInterface4grade().getGrade(1, 2);

            System.out.println("查询成绩！！");
            System.out.println("yyg1的Math成绩：" + score4Math);
            System.out.println("yyg1的English成绩：" + score4English);
            test1.shutdown();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
