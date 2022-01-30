import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="jdbc:mysql://localhost:3306/ecommerce";
		String uname="root";
		String pass="bmcm1999@M";
		
		response.setContentType("text/html");
		
		String pId = request.getParameter("p_ID");
	
		PrintWriter out = response.getWriter();
		
		String query="select * from eproduct";
		out.print("<h1>Displaying the Product Details...</h1>");
		out.print("<table border='1'><tr><th>Product Id</th><th>Product Name</th><th>Product Price</th></tr>");
		out.print("<h1> Product List :- </h1>");
		out.print("<style> table,td,th { border:2px solid red; padding: 10px; }</style>" );
			
		try {
			 
         	Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","bmcm1999@M");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	      
	    
	      
	      ResultSet rs =stmt.executeQuery(query);
	      
	   while(rs.next()) {
		   out.println(rs.getInt(1));
		   out.println(rs.getString(2));
		   out.println(rs.getDouble(3));
	   }
	      
		}
		catch(Exception e){
			
			System.out.println("Some Issue : "+ e.getMessage());
			
			
		}
		
		out.print("</table>");
		
	}

}