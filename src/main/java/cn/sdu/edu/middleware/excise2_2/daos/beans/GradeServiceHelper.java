package cn.sdu.edu.middleware.excise2_2.daos.beans;


/**
* Beans/GradeServiceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from H:/repositoy/corbaPractice/src/main/java/cn/sdu/edu/middleware/excise2_2/daos/dao.idl
* Thursday, November 28, 2013 1:28:44 PM CST
*/

abstract public class GradeServiceHelper
{
  private static String  _id = "IDL:Beans/GradeService:1.0";

  public static void insert (org.omg.CORBA.Any a, cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (cn.sdu.edu.middleware.excise2_2.daos.beans.GradeServiceHelper.id (), "GradeService");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_GradeServiceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService)
      return (cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      cn.sdu.edu.middleware.excise2_2.daos.beans._GradeServiceStub stub = new cn.sdu.edu.middleware.excise2_2.daos.beans._GradeServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService)
      return (cn.sdu.edu.middleware.excise2_2.daos.beans.GradeService)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      cn.sdu.edu.middleware.excise2_2.daos.beans._GradeServiceStub stub = new cn.sdu.edu.middleware.excise2_2.daos.beans._GradeServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
