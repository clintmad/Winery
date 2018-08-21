package listingDbBean;

import java.sql.*;
import java.io.Serializable;

public class ListingBean implements Serializable {

    private int listingID;
    private int wineID;
    private int wineryID;
    private String wineCost;
    private String wineNotes;

    private Connection con;
    private Statement stmt;

    public ListingBean() {
        listingID = 0;
        wineCost = "";
        wineNotes = "";
    }

    public void setListingID(int lID) {
        listingID = lID;
    }
    public int getListingID() {
        return listingID;
    }
    public void setWineID(int wID) {
        wineID = wID;
    }
    public int getWineID() {
        return wineID;
    }
    public void setWineryID(int wyID) {
        wineryID = wyID;
    }
    public int getWineryID() {
        return wineryID;
    }
    public void setWineCost(String wCost) { wineCost = wCost; }
    public String getWineCost() { return wineCost; }
    public void setWineNotes(String wNotes) { wineNotes = wNotes; }
    public String getWineNotes() { return wineNotes; }

    public void listingDb() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            con.setAutoCommit(true);
            stmt = con.createStatement();
        }
        catch(Exception e) {
            System.out.println("Unable to connect to DB");
        }
    }

    public void listingTable() {
        try {
            stmt.executeUpdate("CREATE TABLE winelistings(wine_id NUMBER(20) NOT NULL, wine_type_id NUMBER(20) NOT NULL, winery_id NUMBER(20) NOT NULL, wine_cost VARCHAR2(10) NOT NULL, wine_notes VARCHAR2(50) NOT NULL, PRIMARY KEY (wine_id), FOREIGN KEY(wine_type_id) REFERENCES winetypes, FOREIGN KEY(winery_id) REFERENCES wineries)");

            System.out.println("Wine Listings Table Created");
        }
        catch(SQLException e) {
            System.out.println("Unable to create Wine Listings Table");
        }
        try {
            stmt.executeUpdate("INSERT INTO winelistings VALUES(1, 1, 1, '150', 'Great taste')");
            stmt.executeUpdate("INSERT INTO winelistings VALUES(2, 4, 6, '180.87', 'Great taste')");
            stmt.executeUpdate("INSERT INTO winelistings VALUES(3, 2, 5, '90.50', 'Great taste')");
            stmt.executeUpdate("INSERT INTO winelistings VALUES(4, 3, 4, '50.99', 'Great taste')");
            stmt.executeUpdate("INSERT INTO winelistings VALUES(5, 5, 2, '200.75', 'Great taste')");
            stmt.executeUpdate("INSERT INTO winelistings VALUES(6, 2, 3, '167.89', 'Great taste')");
            stmt.executeUpdate("INSERT INTO winelistings VALUES(7, 4, 6, '40.98', 'Great taste')");
            stmt.executeUpdate("INSERT INTO winelistings VALUES(8, 1, 5, '99.99', 'Great taste')");
            System.out.println("Wine Listings inserted");
        }
        catch(SQLException e) {
            System.out.println("Unable to insert data");
        }
    }
    public void dropListing() {
        try {
            stmt.executeUpdate("DROP TABLE winelistings");
            stmt.close();
            con.close();
            System.out.println("Wine Listings Table Dropped");
        }
        catch(SQLException e) {
            System.out.println("Unable to drop Wine Listings table");
        }
    }
    public void addListing() {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO winelistings(wine_id, wine_type_id, winery_id)VALUES(?, ?, ?)");

            pst.setInt(1, listingID);
            pst.setInt(2, wineID);
            pst.setInt(3, wineryID);

            pst.executeUpdate();
            pst.close();
            stmt.close();
            con.close();
            System.out.println("Wine Listing Added");
        }
        catch(SQLException e) {
            System.out.println("Unable to add Wine Listing");
        }
    }
}