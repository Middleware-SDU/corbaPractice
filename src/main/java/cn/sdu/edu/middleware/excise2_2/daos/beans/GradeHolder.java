package cn.sdu.edu.middleware.excise2_2.daos.beans;

/**
* Beans/GradeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from H:/repositoy/corbaPractice/src/main/java/cn/sdu/edu/middleware/excise2_2/daos/dao.idl
* Thursday, November 28, 2013 1:28:44 PM CST
*/

public final class GradeHolder implements org.omg.CORBA.portable.Streamable
{
  public cn.sdu.edu.middleware.excise2_2.daos.beans.Grade value = null;

  public GradeHolder ()
  {
  }

  public GradeHolder (cn.sdu.edu.middleware.excise2_2.daos.beans.Grade initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = cn.sdu.edu.middleware.excise2_2.daos.beans.GradeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    cn.sdu.edu.middleware.excise2_2.daos.beans.GradeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return cn.sdu.edu.middleware.excise2_2.daos.beans.GradeHelper.type ();
  }

}
