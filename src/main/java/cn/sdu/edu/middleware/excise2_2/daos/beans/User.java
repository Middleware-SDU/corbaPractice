package cn.sdu.edu.middleware.excise2_2.daos.beans;


/**
* Beans/User.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from H:/repositoy/corbaPractice/src/main/java/cn/sdu/edu/middleware/excise2_2/daos/dao.idl
* Thursday, November 28, 2013 1:28:44 PM CST
*/

public final class User implements org.omg.CORBA.portable.IDLEntity
{
  public int examNo = (int)0;
  public String userName = null;

  public User ()
  {
  } // ctor

  public User (int _examNo, String _userName)
  {
    examNo = _examNo;
    userName = _userName;
  } // ctor

} // class User