import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ViewData extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection con;
        Statement stmt = null;
        ResultSet rs;
        printHeader(out);
        try{
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            con.setAutoCommit(true);
            stmt = con.createStatement();
        }
        catch(Exception e) {
        }
        try {
            printTypesHead(out);
            rs = stmt.executeQuery("SELECT * FROM winetypes ORDER BY wine_type_id");
            while (rs.next()) {
                out.println("<tr>");
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    out.println("<td>");
                    out.print((rs.getString(i)).trim() + " ");
                    out.println("</td>");
                }
                out.print("</tr>");
            }
            out.println("</table>");
            out.println("</div>");
        }
        catch(Exception e) {
            System.out.println("You don't have any wine types");
        }
        try {
            printWineriesHead(out);
            rs = stmt.executeQuery("SELECT * FROM wineries ORDER BY winery_id");
            while (rs.next()) {
                out.println("<tr>");
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    out.println("<td>");
                    out.print((rs.getString(i)).trim() + " ");
                    out.println("</td>");
                }
                out.print("</tr>");
            }
            out.println("</table>");
            out.println("</div>");
        }
        catch(Exception e) {
            System.out.println("You don't have any wineries");
        }
        try {
            printListingsHead(out);
            rs = stmt.executeQuery("SELECT * FROM winelistings ORDER BY wine_id");
            while (rs.next()) {
                out.println("<tr>");
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    out.println("<td>");
                    out.print((rs.getString(i)).trim() + " ");
                    out.println("</td>");
                }
                out.print("</tr>");
            }
            out.println("</table>");
            out.println("</div>");
        }
        catch(Exception e) {
            System.out.println("You don't have any wineries");
        }
        printFooter(out);
    }
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }

    public void printHeader(PrintWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Data</title>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
        out.println("<link href='https://fonts.googleapis.com/css?family=Alegreya:700|Lobster' rel='stylesheet'>");
        out.println("<link rel='stylesheet' href='styles/main.css' type='text/css'>");
        out.println("</head>");
        out.println("<body class='container-fluid view-page'>");
    }
    public void printTypesHead(PrintWriter out) {
        out.println("<div class='row wrow'>");
        out.println("<table class='table wtr table-bordered'>");
        out.println("<caption class='tbl-cap text-center create-heading stroke'>Wine Types</caption>");
        out.println("<tr>");
        out.println("<th>");
        out.println("Wine Types ID");
        out.println("</th>");
        out.println("<th>");
        out.println("Grape");
        out.println("</th>");
        out.println("<th>");
        out.println("Year");
        out.println("</th>");
        out.println("<th>");
        out.println("Vintage");
        out.println("</th>");
        out.println("</tr>");
    }
    public void printWineriesHead(PrintWriter out) {
        out.println("<div class='row wrow'>");
        out.println("<table class='table wtr table-bordered'>");
        out.println("<caption class='tbl-cap text-center create-heading stroke'>Wineries</caption>");
        out.println("<tr>");
        out.println("<th>");
        out.println("Winery ID");
        out.println("</th>");
        out.println("<th>");
        out.println("Name");
        out.println("</th>");
        out.println("<th>");
        out.println("Region");
        out.println("</th>");
        out.println("<th>");
        out.println("Contact");
        out.println("</th>");
        out.println("<th>");
        out.println("Phone");
        out.println("</th>");
        out.println("</tr>");
    }
    public void printListingsHead(PrintWriter out) {
        out.println("<div class='row wrow'>");
        out.println("<table class='table wtr table-bordered'>");
        out.println("<caption class='tbl-cap text-center create-heading stroke'>Listings</caption>");
        out.println("<tr>");
        out.println("<th>");
        out.println("Listing ID");
        out.println("</th>");
        out.println("<th>");
        out.println("Wine Type ID");
        out.println("</th>");
        out.println("<th>");
        out.println("Winery ID");
        out.println("</th>");
        out.println("<th>");
        out.println("Wine Cost");
        out.println("</th>");
        out.println("<th>");
        out.println("Tasting Notes");
        out.println("</th>");
        out.println("</tr>");
    }
    public void printFooter(PrintWriter out) {
        out.println("<div class='row flex-row ext-marg'>");
        out.println("<div class='buttons'>");
        out.println("<button class='btn dir-btn'><a class='btn-font' href='index.jsp'>Home</a></button>");
        out.println("<button class='btn dir-btn'><a class='btn-font' href='/createdata'>Enter Data</a></button>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
