package com.cerner.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cerner.model.Employee;
import com.cerner.util.SessionUtil;

public class EmployeeDAO {
  
  public void addEmployee(Employee bean){
    Session session = SessionUtil.getSession();    
    Transaction tx = session.beginTransaction();
    addEmployee(session,bean);    
    tx.commit();
    session.close();
    
  }
  
  private void addEmployee(Session session, Employee bean){
    Employee employee = new Employee();
    
    employee.setName(bean.getName());
    employee.setAge(bean.getAge());
    employee.setAct_ind(1);
    session.save(employee);
  }
  
  public List<Employee> getEmployees(){
    Session session = SessionUtil.getSession();  
      Query query = session.createQuery("from Employee where act_ind=1");
    List<Employee> employees =  query.list();
        session.close();
    return employees;
  }

  public int deleteEmployee(int id) {
    Session session = SessionUtil.getSession(); 	
    Transaction tx = session.beginTransaction();
    String hql = "update Employee set act_ind = 0 where id = :id";
    Query query = session.createQuery(hql);
    query.setParameter("id",id);
  
    int rowCount = query.executeUpdate();
    System.out.println("Rows affected: " + rowCount);
    tx.commit();
    session.close();
    return rowCount;
  }
  
  public int updateEmployee(int id, Employee emp){
     if(id <=0)  
         return 0;  
     Session session = SessionUtil.getSession();
      Transaction tx = session.beginTransaction();
      String hql = "update Employee set name = :name, age=:age where id = :id";
      Query query = session.createQuery(hql);
      query.setParameter("id",id);
      query.setParameter("name",emp.getName());
      query.setParameter("age",emp.getAge());
      int rowCount = query.executeUpdate();
      System.out.println("Rows affected: " + rowCount);
      tx.commit();
      session.close();
      return rowCount;
  }
}
