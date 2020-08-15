// package cash_register;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import tracom.academy.database.Database;

// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.sql.Connection;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;


// @WebServlet(urlPatterns = {"/register"})
// public class registerAction extends HttpServlet {

//     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//         String first_name = request.getParameter("first_name");
//         String last_name = request.getParameter("last_name");
//         String job = request.getParameter("job");

//         Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "tracom","tracom", "Mclass#64",true);
//         database.executeQuery("insert into register(register_id,first_name,last_name,job) values(" + (new Random()).nextInt(10000) + ",'" + first_name + "','" + last_name+ "','" + job+
//                 "')");

//         response.getWriter().println("Saved");



//     }

//     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

//         List<Register> register = new ArrayList<Register>();

//         Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "tracom","tracom", "Mclass#64",true);
//         Connection conn = database.getDbConnection();
//         ResultSet rs = null;
//         try {
//             Statement stmt = conn.createStatement();
//             rs = stmt.executeQuery("SELECT * FROM tracom.register");
//             System.out.println("fetching data....");
//         } catch (SQLException throwables) {
//             throwables.printStackTrace();
//         }

//         if (rs != null) {
//             System.out.println("rs is not null.....");
//             try {
//                 while (rs.next()) {
//                     register.add(new Register(
//                             rs.getInt(1),
//                             rs.getString(2),
//                             rs.getString(3),
//                             rs.getString(4)));
//                 }
//             } catch (SQLException err) {
//                 err.printStackTrace();
//             }

//         }else
//             System.out.println("rs is null");

//         System.out.println("==================================");
//         System.out.println(register);


//         // response.sendRedirect("./webapp/register/display.jsp");

//         ObjectMapper json = new ObjectMapper();
//         response.getWriter().println(json.writeValueAsString(register));



//     }

// }
