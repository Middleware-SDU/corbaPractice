package cn.sdu.edu.middleware.excise2_2.daos.beans;


/**
* Beans/UserServiceOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from H:/repositoy/corbaPractice/src/main/java/cn/sdu/edu/middleware/excise2_2/daos/dao.idl
* Thursday, November 28, 2013 1:28:44 PM CST
*/

public interface UserServiceOperations 
{
  void save (cn.sdu.edu.middleware.excise2_2.daos.beans.User user);
  void delete (int examNo);
  void update (cn.sdu.edu.middleware.excise2_2.daos.beans.User user);
  cn.sdu.edu.middleware.excise2_2.daos.beans.User find (int examNo);
  cn.sdu.edu.middleware.excise2_2.daos.beans.User[] list ();
} // interface UserServiceOperations
