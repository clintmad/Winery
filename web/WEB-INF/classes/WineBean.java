package wineDbBean;

import java.sql.*;
import java.io.Serializable;

public class WineBean implements Serializable {

    private int wineID;
    private String wineGrape;
    private int wineYear;
    private String wineVint;

    private Connection con;
    private Statement stmt;

    public WineBean () {
        wineID = 0;
        wineGrape = "";
        wineYear = 0;
        wineVint = "";
    }
    public void setWineID(int wID) {
        wineID = wID;
    }
    public int getWineID() {
        return wineID;
    }
    public void setWineGrape(String wGrape) {
        wineGrape = wGrape;
    }
    public String getWineGrape() {
        return wineGrape;
    }
    public void setWineYear(int wYear) {
        wineYear = wYear;
    }
    public int getWineYear() {
        return wineYear;
    }
    public void setWineVint(String wVint) {
        wineVint = wVint;
    }
    public String getWineVint() {
        return wineVint;
    }

    public void wineDb() {
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

    public void wineTable() {
        try {
            stmt.executeUpdate("CREATE TABLE winetypes(wine_type_id NUMBER(20) NOT NULL, wine_grape VARCHAR2(20) NOT NULL, wine_year NUMBER(4) NOT NULL, wine_vint VARCHAR2(3) NOT NULL, PRIMARY KEY (wine_type_id))");

            System.out.println("Wine Types Table Created");
        }
        catch(SQLException e) {
            System.out.println("Unable to create Wine Types Table");
        }
        try {
            stmt.executeUpdate("INSERT INTO winetypes VALUES(1, 'Merlot', 1968, 'Yes')");
            stmt.executeUpdate("INSERT INTO winetypes VALUES(2, 'Chardonnay', 1955, 'Yes')");
            stmt.executeUpdate("INSERT INTO winetypes VALUES(3, 'Riesling', 1990, 'Yes')");
            stmt.executeUpdate("INSERT INTO winetypes VALUES(4, 'Pinot Noir', 2000, 'Yes')");
            stmt.executeUpdate("INSERT INTO winetypes VALUES(5, 'Cabernet Franc', 1980, 'Yes')");
            System.out.println("Wine Types inserted");
        }
        catch(SQLException e) {
            System.out.println("Unable to insert data");
        }
    }

    public void dropWine() {
        try {
            stmt.executeUpdate("DROP TABLE winetypes");
            stmt.close();
            con.close();
            System.out.println("Wine Types Table Dropped");
        }
        catch(SQLException e) {
            System.out.println("Unable to drop Wine Types table");
        }
    }

    public void addWine() {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO winetypes(wine_type_id, wine_grape, wine_year, wine_vint)VALUES(?, ?, ?, ?)");

            pst.setInt(1, wineID);
            pst.setString(2, wineGrape);
            pst.setInt(3, wineYear);
            pst.setString(4, wineVint);

            pst.executeUpdate();
            pst.close();
            stmt.close();
            con.close();
            System.out.println("Wine Type Added");
        }
        catch(SQLException e) {
            System.out.println("Unable to add Wine Type");

        }
    }
}