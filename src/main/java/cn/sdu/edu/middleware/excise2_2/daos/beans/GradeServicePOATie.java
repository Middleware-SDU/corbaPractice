package cn.sdu.edu.middleware.excise2_2.daos.beans;


/**
* Beans/GradeServicePOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from H:/repositoy/corbaPractice/src/main/java/cn/sdu/edu/middleware/excise2_2/daos/dao.idl
* Thursday, November 28, 2013 1:28:44 PM CST
*/

public class GradeServicePOATie extends GradeServicePOA
{

  // Constructors

  public GradeServicePOATie ( cn.sdu.edu.middleware.excise2_2.daos.beans.GradeServiceOperations delegate ) {
      this._impl = delegate;
  }
  public GradeServicePOATie ( cn.sdu.edu.middleware.excise2_2.daos.beans.GradeServiceOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public cn.sdu.edu.middleware.excise2_2.daos.beans.GradeServiceOperations _delegate() {
      return this._impl;
  }
  public void _delegate (cn.sdu.edu.middleware.excise2_2.daos.beans.GradeServiceOperations delegate ) {
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
  public cn.sdu.edu.middleware.excise2_2.daos.beans.Grade[] list ()
  {
    return _impl.list();
  } // list


  // 0Ð*f@	Ñîé
  public cn.sdu.edu.middleware.excise2_2.daos.beans.Grade[] getGrades (int examNo)
  {
    return _impl.getGrades(examNo);
  } // getGrades


  // 0Ð*fÐèþé
  public int getGrade (int examNo, int subjectNo)
  {
    return _impl.getGrade(examNo, subjectNo);
  } // getGrade


  // 0Ð*f@	Ñîé
  public void setGrade (int examNo, int subjectNo, int score)
  {
    _impl.setGrade(examNo, subjectNo, score);
  } // setGrade

  private cn.sdu.edu.middleware.excise2_2.daos.beans.GradeServiceOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GradeServicePOATie
