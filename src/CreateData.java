import wineDbBean.WineBean;
import wineryDbBean.WineryBean;
import listingDbBean.ListingBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CreateData extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHeader(out);
        printTypeForm(out);
        printWineryForm(out);
        printListingForm(out);
        printFooter(out);
    }
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHeader(out);
        try {
            printTypeForm(out);
            WineBean wBean = new WineBean();
            wBean.wineDb();
            wBean.setWineID(Integer.parseInt(request.getParameter("wineid")));
            wBean.setWineGrape(request.getParameter("winegrape"));
            wBean.setWineYear(Integer.parseInt(request.getParameter("wineyear")));
            wBean.setWineVint(request.getParameter("winevint"));
            wBean.addWine();
        }
        catch(Exception e) {
            System.out.println("Unable to add wine type.");
        }
        try {
            printWineryForm(out);
            WineryBean wyBean = new WineryBean();
            wyBean.wineryDb();
            wyBean.setWineryID(Integer.parseInt(request.getParameter("wineryid")));
            wyBean.setWineryName(request.getParameter("wineryname"));
            wyBean.setWineryReg(request.getParameter("wineryreg"));
            wyBean.setWineryCont(request.getParameter("winerycont"));
            wyBean.setWineryPho(Integer.parseInt(request.getParameter("winerypho")));
            wyBean.addWinery();
        }
        catch(Exception e) {
            System.out.println("Unable to add winery.");
        }
        try{
            printListingForm(out);
            ListingBean lBean = new ListingBean();
            lBean.listingDb();
            lBean.setListingID(Integer.parseInt(request.getParameter("listingid")));
            lBean.setWineID(Integer.parseInt(request.getParameter("winetypeid")));
            lBean.setWineryID(Integer.parseInt(request.getParameter("winery-id")));
            lBean.setWineCost(request.getParameter("winecost"));
            lBean.setWineNotes(request.getParameter("winenotes"));
            lBean.addListing();
        }
        catch(Exception e) {
            System.out.println("Unable to add listing.");
        }
        printFooter(out);
    }
    public void printHeader(PrintWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Create Data</title>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
        out.println("<link href='https://fonts.googleapis.com/css?family=Alegreya:700|Lobster' rel='stylesheet'>");
        out.println("<link rel='stylesheet' href='styles/main.css' type='text/css'>");
        out.println("</head>");
        out.println("<body class='container-fluid form-page'>");
        out.println("<div class='row'>");
        out.println("<div class='heading'>");
        out.println("<h1 class='text-center create-heading stroke'>Insert Data</h1>");
        out.println("</div>");
        out.println("</div>");

    }
    public void printTypeForm(PrintWriter out) {
        out.println("<div class='row'>");
        out.println("<div class='col-xs-3'></div>");
        out.println("<div class='col-xs-6'>");
        out.println("<div class='form-heading'>");
        out.println("<h2 class='text-center create-text stroke'>Wine Types</h2>");
        out.println("</div>");
        out.println("<form action='/createdata' method='post' class='wineForm'>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='wineid' class='form-control' placeholder='Wine Type ID'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='winegrape' class='form-control' placeholder='Wine Grape'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='wineyear' class='form-control' placeholder='Wine Year'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='winevint' class='form-control' placeholder='Vintage Yes/No'>");
        out.println("</div>");
        out.println("<button name='first' type='submit' class='dir-btn btn btn-default btn-block'>Add Wine Type</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("<div class='col-xs-3'></div>");
        out.println("</div>");
    }
    public void printWineryForm(PrintWriter out) {
        out.println("<div class='row'>");
        out.println("<div class='col-xs-3'></div>");
        out.println("<div class='col-xs-6'>");
        out.println("<div class='form-heading'>");
        out.println("<h2 class='text-center create-text stroke'>Winery</h2>");
        out.println("</div>");
        out.println("<form action='/createdata' method='post' class='wineForm'>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='wineryid' class='form-control' placeholder='Winery ID'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='wineryname' class='form-control' placeholder='Winery Name'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='wineryreg' class='form-control' placeholder='Winery Region'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='winerycont' class='form-control' placeholder='Contact Name'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='winerypho' class='form-control' placeholder='Phone Number'>");
        out.println("</div>");
        out.println("<button name='second' type='submit' class='dir-btn btn btn-default btn-block'>Add Winery</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("<div class='col-xs-3'></div>");
        out.println("</div>");
    }
    public void printListingForm(PrintWriter out) {
        out.println("<div class='row'>");
        out.println("<div class='col-xs-3'></div>");
        out.println("<div class='col-xs-6'>");
        out.println("<div class='form-heading'>");
        out.println("<h2 class='text-center create-text stroke'>Wine Listings</h2>");
        out.println("</div>");
        out.println("<form action='/createdata' method='post' class='wineForm'>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='listingid' class='form-control' placeholder='Listing ID'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='winetypeid' class='form-control' placeholder='Wine Type ID'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='winery-id' class='form-control' placeholder='Winery ID'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='winecost' class='form-control' placeholder='Wine Cost'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='winenotes' class='form-control' placeholder='Wine Tasting Notes'>");
        out.println("</div>");
        out.println("<button name='third' type='submit' class='dir-btn btn btn-default btn-block'>Add Listing</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("<div class='col-xs-3'></div>");
        out.println("</div>");
    }
    public void printFooter(PrintWriter out) {
        out.println("</div>");
        out.println("<div class='row flex-row ext-marg'>");
        out.println("<div class='buttons'>");
        out.println("<button class='btn dir-btn'><a class='btn-font' href='index.jsp'>Home</a></button>");
        out.println("<button class='btn dir-btn'><a class='btn-font' href='/viewdata'>View Data</a></button>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}