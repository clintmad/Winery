package wineryDbBean;

import java.sql.*;
import java.io.Serializable;

public class WineryBean implements Serializable {
    private int wineryID;
    private String wineryName;
    private String wineryReg;
    private String wineryCont;
    private int wineryPho;

    private Connection con;
    private Statement stmt;

    public WineryBean() {
        wineryID = 0;
        wineryName = "";
        wineryReg = "";
        wineryCont = "";
        wineryPho = 0;
    }
    public void setWineryID(int wyID) {
        wineryID = wyID;
    }
    public int getWineryID() {
        return wineryID;
    }
    public void setWineryName(String wyName) {
        wineryName = wyName;
    }
    public String getWineryName() {
        return wineryName;
    }
    public void setWineryReg(String wReg) {
        wineryReg = wReg;
    }
    public String getWineryReg() {
        return wineryReg;
    }
    public void setWineryCont(String wCont) {
        wineryCont = wCont;
    }
    public String getWineryCont() {
        return wineryCont;
    }
    public void setWineryPho(int wPho) {
        wineryPho = wPho;
    }
    public int getWineryPho() {
        return wineryPho;
    }

    public void wineryDb() {
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

    public void wineryTable() {
        try {
            stmt.executeUpdate("CREATE TABLE wineries(winery_id NUMBER(20) NOT NULL, winery_name VARCHAR2(20) NOT NULL, winery_region VARCHAR2(30) NOT NULL, winery_contact VARCHAR2(30) NOT NULL, winery_phone NUMBER(15), PRIMARY KEY (winery_id))");

            System.out.println("Wineries Table Created");
        }
        catch(SQLException e) {
            System.out.println("Unable to create Wineries Table");
        }
        try {
            stmt.executeUpdate("INSERT INTO wineries VALUES(1, 'Leeuwin Estate', 'Margaret River', 'Tricia Horgan', 61897590000)");
            stmt.executeUpdate("INSERT INTO wineries VALUES(2, 'Vasse Felix', 'Margaret River', 'Tom Cullity', 61897565000)");
            stmt.executeUpdate("INSERT INTO wineries VALUES(3, 'Voyager Estate', 'Margaret River', 'Steve James', 61897576354)");
            stmt.executeUpdate("INSERT INTO wineries VALUES(4, 'Josef Chromy Wines', 'King Valley', 'Joe', 0363358700)");
            stmt.executeUpdate("INSERT INTO wineries VALUES(5, 'Moorilla', 'Derwent River', 'David Walsh', 61362779960)");
            stmt.executeUpdate("INSERT INTO wineries VALUES(6, 'Tahbilk Winery', 'Goulburn Valley', 'Alister Purbrick', 0357942555)");
            System.out.println("Wineries Inserted");
        }
        catch(SQLException e) {
            System.out.println("Unable to insert data");
        }
    }

    public void dropWinery() {
        try {
            stmt.executeUpdate("DROP TABLE wineries");
            stmt.close();
            con.close();
            System.out.println("Wineries Table Dropped");
        }
        catch(SQLException e) {
            System.out.println("Unable to drop Wineries table");
        }
    }

    public void addWinery() {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO wineries(winery_id, winery_name, winery_region, winery_contact, winery_phone)VALUES(?, ?, ?, ?, ?)");

            pst.setInt(1, wineryID);
            pst.setString(2, wineryName);
            pst.setString(3, wineryReg);
            pst.setString(4, wineryCont);
            pst.setInt(5, wineryPho);

            pst.executeUpdate();
            pst.close();
            stmt.close();
            con.close();
            System.out.println("Winery Added");
        }
        catch(SQLException e) {
            System.out.println("Unable to add winery");

        }
    }
}