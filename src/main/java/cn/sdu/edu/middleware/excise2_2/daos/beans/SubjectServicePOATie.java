package cn.sdu.edu.middleware.excise2_2.daos.beans;


/**
* Beans/SubjectServicePOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from H:/repositoy/corbaPractice/src/main/java/cn/sdu/edu/middleware/excise2_2/daos/dao.idl
* Thursday, November 28, 2013 1:28:44 PM CST
*/

public class SubjectServicePOATie extends SubjectServicePOA
{

  // Constructors

  public SubjectServicePOATie ( cn.sdu.edu.middleware.excise2_2.daos.beans.SubjectServiceOperations delegate ) {
      this._impl = delegate;
  }
  public SubjectServicePOATie ( cn.sdu.edu.middleware.excise2_2.daos.beans.SubjectServiceOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public cn.sdu.edu.middleware.excise2_2.daos.beans.SubjectServiceOperations _delegate() {
      return this._impl;
  }
  public void _delegate (cn.sdu.edu.middleware.excise2_2.daos.beans.SubjectServiceOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public void save (cn.sdu.edu.middleware.excise2_2.daos.beans.Subject subject)
  {
    _impl.save(subject);
  } // save

  public void delete (int subjectNo)
  {
    _impl.delete(subjectNo);
  } // delete

  public void update (cn.sdu.edu.middleware.excise2_2.daos.beans.Subject subject)
  {
    _impl.update(subject);
  } // update

  public cn.sdu.edu.middleware.excise2_2.daos.beans.User find (int subjectNo)
  {
    return _impl.find(subjectNo);
  } // find

  public cn.sdu.edu.middleware.excise2_2.daos.beans.Subject[] list ()
  {
    return _impl.list();
  } // list

  private cn.sdu.edu.middleware.excise2_2.daos.beans.SubjectServiceOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class SubjectServicePOATie
