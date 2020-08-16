package finance;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.hibernate.Session;
import org.hibernate.Transaction;

import database.HibernateHelper;


@WebServlet(urlPatterns = { "/finance" })
public class TransactionAction extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
           TransactionClass transactions = new TransactionClass();
            //int id = Integer.parseInt(request.getParameter("tid"));
            String AccNo= request.getParameter("tAccNo");
            String Amount= request.getParameter("tAmount");
            //transactions.setId(id);
            transactions.setAccNo(AccNo);
            transactions.setAmount(Amount);
            session.save(transactions);
            response.getWriter().println("Data saved successfully!!");
            tx.commit();
        }catch (Exception e){
            // TODO: handle exception properly
            response.getWriter().println("An error has occurred");
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            List<TransactionClass> transactions = session.createQuery("From TransactionClass r").getResultList();
            //List<Student> students = session.createCriteria(Student.class).list();
            ObjectMapper json = new ObjectMapper();
            response.getWriter().println(json.writeValueAsString(transactions));
            tx.commit();
        }catch (Exception e){
            // TODO: handle exception properly
            response.getWriter().println("An error has occurred");
            e.printStackTrace();
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String id = request.getParameter("id");
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            TransactionClass transcations = session.get(TransactionClass.class, Integer.parseInt(id));
            session.delete(transcations);
            response.getWriter().println("Data deleted Successfully!!");
            tx.commit();
        }catch (Exception e){
            // TODO: handle exception properly
            response.getWriter().println("An error has occurred");
            e.printStackTrace();
        }
    }
}
