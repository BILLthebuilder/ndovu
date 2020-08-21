package finance;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.hibernate.Session;
import org.hibernate.Transaction;

import database.HibernateHelper;
import org.json.JSONException;
import org.json.JSONObject;


@WebServlet(urlPatterns = { "/save" })
public class TransactionAction extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Get data from POS and split it
        String data = request.getParameter("data");
        String splitData[] =  data.split("-");

//        System.out.println(splitData[2]);

        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            TransactionClass transactions = new TransactionClass();
            String AccNo= splitData[0];
            String fullAmount = splitData[1];

            // Extract amount without cents
            String stringAmount = fullAmount.substring(0, fullAmount.length() - 2);

            // Extract cents
            String cents = fullAmount.substring(fullAmount.length() - 2);

            // Put amount in proper format
            int intAmount = Integer.parseInt(stringAmount);
            String amount = NumberFormat.getNumberInstance(Locale.UK).format(intAmount);


            String decimalSeparator = ".";
            String formattedAmount= amount +decimalSeparator+ cents;
            //System.out.println(formattedAmount);
            transactions.setAccNo(AccNo);
            transactions.setAmount(formattedAmount);
            session.save(transactions);
            response.getWriter().println("Data saved successfully!!");
            tx.commit();
        }catch (Exception e){
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
