// package database.cash register;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import tracom.academy.database.Database;

// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;


// //@WebServlet(urlPatterns = {"/register"})
// public class display extends HttpServlet {

//     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

// //        response.sendRedirect(request.getContextPath() + "/display.java");

//     }

//     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

//         String AccNo = request.getParameter("AccNo");
//         String Amount = request.getParameter("Amount");
//         String job = request.getParameter("job");

//         Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "finance","finance", "Mclass#64",true);
//         database.executeQuery("select * from cash register ");

// //        response.getWriter().println("Saved");

//     }
// }
