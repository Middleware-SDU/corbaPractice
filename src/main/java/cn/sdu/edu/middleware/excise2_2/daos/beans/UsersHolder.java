package cn.sdu.edu.middleware.excise2_2.daos.beans;


/**
* Beans/UsersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from H:/repositoy/corbaPractice/src/main/java/cn/sdu/edu/middleware/excise2_2/daos/dao.idl
* Thursday, November 28, 2013 1:28:44 PM CST
*/

public final class UsersHolder implements org.omg.CORBA.portable.Streamable
{
  public cn.sdu.edu.middleware.excise2_2.daos.beans.User value[] = null;

  public UsersHolder ()
  {
  }

  public UsersHolder (cn.sdu.edu.middleware.excise2_2.daos.beans.User[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = cn.sdu.edu.middleware.excise2_2.daos.beans.UsersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    cn.sdu.edu.middleware.excise2_2.daos.beans.UsersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return cn.sdu.edu.middleware.excise2_2.daos.beans.UsersHelper.type ();
  }

}