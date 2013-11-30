package cn.sdu.edu.middleware.excise2_2.daos.beans;


/**
* Beans/SubjectHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from H:/repositoy/corbaPractice/src/main/java/cn/sdu/edu/middleware/excise2_2/daos/dao.idl
* Thursday, November 28, 2013 1:28:44 PM CST
*/

abstract public class SubjectHelper
{
  private static String  _id = "IDL:Beans/Subject:1.0";

  public static void insert (org.omg.CORBA.Any a, cn.sdu.edu.middleware.excise2_2.daos.beans.Subject that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static cn.sdu.edu.middleware.excise2_2.daos.beans.Subject extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "subjectNo",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "subjectName",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (cn.sdu.edu.middleware.excise2_2.daos.beans.SubjectHelper.id (), "Subject", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static cn.sdu.edu.middleware.excise2_2.daos.beans.Subject read (org.omg.CORBA.portable.InputStream istream)
  {
    cn.sdu.edu.middleware.excise2_2.daos.beans.Subject value = new cn.sdu.edu.middleware.excise2_2.daos.beans.Subject ();
    value.subjectNo = istream.read_long ();
    value.subjectName = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, cn.sdu.edu.middleware.excise2_2.daos.beans.Subject value)
  {
    ostream.write_long (value.subjectNo);
    ostream.write_string (value.subjectName);
  }

}