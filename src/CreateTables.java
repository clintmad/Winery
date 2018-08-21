import wineDbBean.WineBean;
import listingDbBean.ListingBean;
import wineryDbBean.WineryBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CreateTables extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHeader(out);
        try {
            WineBean wBean = new WineBean();
            wBean.wineDb();
            wBean.wineTable();
            out.println("<div class='c-row'>");
            out.println("<h3 class='create-text stroke'>Wine Types Table Created");
            out.println("</div>");
        }
        catch(Exception e) {
            out.println("<div class='c-row'>");
            out.println("<h3 class='create-text stroke'>Wine Types Not Created");
            out.println("</div>");
        }
        try {
            WineryBean wyBean = new WineryBean();
            wyBean.wineryDb();
            wyBean.wineryTable();
            out.println("<div class='c-row'>");
            out.println("<h3 class='create-text stroke'>Wineries Table Created");
            out.println("</div>");
        }
        catch(Exception e) {
            out.println("<div class='c-row'>");
            out.println("<h3 class='create-text stroke'>Wineries Not Created");
            out.println("</div>");
        }
        try {
            ListingBean lBean = new ListingBean();
            lBean.listingDb();
            lBean.listingTable();
            out.println("<div class='c-row'>");
            out.println("<h3 class='create-text stroke'>Wine Listings Table Created");
            out.println("</div>");
        }
        catch(Exception e) {
            out.println("<div class='c-row'>");
            out.println("<h3 class='create-text stroke'>Wine Listings Not Created");
            out.println("</div>");
        }
        printFooter(out);
    }
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }
    public void printHeader(PrintWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Create Tables</title>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
        out.println("<link href='https://fonts.googleapis.com/css?family=Alegreya:700|Lobster' rel='stylesheet'>");
        out.println("<link rel='stylesheet' href='styles/main.css' type='text/css'>");
        out.println("</head>");
        out.println("<body class='container-fluid create-page'>");
        out.println("<div class='row'>");
        out.println("<h1 class='create-heading stroke'>Attempted to Create Tables</h1>");
        out.println("</div>");
        out.println("<div class='row row-eq-height tables-row'>");
        out.println("<div class='col-xs-5 col-xs-offset-1'>");
        out.println("<img class='glasses img-responsive' src='img/glasses.jpg'>");
        out.println("</div>");
        out.println("<div class='col-xs-6 flex-table'>");
    }

    public void printFooter(PrintWriter out) {
        out.println("</div>");
        out.println("</div>");
        out.println("<div class='row flex-row ext-marg'>");
        out.println("<div class='buttons'>");
        out.println("<button class='btn dir-btn'><a class='btn-font' href='index.jsp'>Home</a></button>");
        out.println("<button class='btn dir-btn'><a class='btn-font' href='/createdata'>Enter Data</a></button>");
        out.println("<button class='btn dir-btn'><a class='btn-font' href='/viewdata'>View Data</a></button>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
