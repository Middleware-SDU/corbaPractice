package cn.sdu.edu.middleware.excise2_1.service;

import java.util.Properties;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import cn.sdu.edu.middleware.excise2_1.MyServer.MyService;
import cn.sdu.edu.middleware.excise2_1.MyServer.MyServiceHelper;

/**
 * 
 * @author Yonggang Yuan
 *
 */

public class Server_AOM {

    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
        props.setProperty("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");
        try {
            // 启动命名服务需要的参数
            props.setProperty("ORBInitRef.NameService", "corbaloc::localhost:30000/NameService");
            // 初始化ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
            // 获取根POA引用
            POA poaRoot = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            // 激活POA管理器
            poaRoot.the_POAManager().activate();
            // 实例化一个MyServiceServerImpl对象
            MyServiceServerImpl serviceImpl = new MyServiceServerImpl();
            // 从servant获得一个对象引用
            org.omg.CORBA.Object refObj = poaRoot.servant_to_reference(serviceImpl);
            // 获得对象接口引用
            MyService service = MyServiceHelper.narrow(refObj);
            // 命名上下文
            org.omg.CORBA.Object ncObj = orb.resolve_initial_references("NameService");
            NamingContextExt nc = NamingContextExtHelper.narrow(ncObj);
            // 绑定一个服务引用,以便客户端可以调用
            nc.rebind(nc.to_name("Simple.MyService"), service);
            System.out.println("服务器端已经运行！");
            // 运行ORB
            orb.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
