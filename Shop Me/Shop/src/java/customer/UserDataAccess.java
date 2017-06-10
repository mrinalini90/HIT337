/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

/**
 *
 * @author Meeru
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import static org.eclipse.persistence.jpa.rs.util.JPARSLogger.exception;

/**
 *
 * @author Meeru
 */
public class UserDataAccess implements UserInterface {

    private final String connectionURL = "jdbc:derby://localhost:1527/shopmedb";

    /**
     *
     * @return
     */
    @Override
    public boolean getConnection() {
        boolean connected = false;
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            connected = true;
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            connected = false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            connected = false;
        }
        return connected;
    }

    /**
     *
     * @param name
     * @param email
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public void addUser(String name, String email, String password)  {
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO CUSTOMER (name,password,email) VALUES ( ?,?,?)");
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.executeUpdate();
            statement.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override
    public ArrayList<Customer> getAllUser() {

        ArrayList<Customer> users = new ArrayList<Customer>();
        String name, email, password;
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            String query = "SELECT * FROM customer ";
            Statement statement = conn.createStatement();
            ResultSet rs = null;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                name = rs.getString("name");
                password = rs.getString("password");
                email = rs.getString("email");
                Customer itemobject = new Customer(name, password, email);
                users.add(itemobject);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public ArrayList<String> getUserEmails(){

        ArrayList<String> emails = new ArrayList<>();
        String name, email, password;
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            String query = "SELECT email FROM customer ";
            Statement statement = conn.createStatement();
            ResultSet rs = null;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                email = rs.getString("email");
                emails.add(email);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emails;
    }

    @Override
    public void getUserNames() {

        ArrayList<String> names = new ArrayList<>();
        Customer user = new Customer();
        String name, email, password;
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            String query = "SELECT name FROM customer ";
            Statement statement = conn.createStatement();
            ResultSet rs = null;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                name = rs.getString("name");
                names.add(name);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Customer getUserByEmail(String email)  {
        String emailPresent = null;
        Customer user = new Customer();
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            String query = "SELECT * FROM customer WHERE email ='" + email + "'";
            Statement statement = conn.createStatement();
            ResultSet rs = null;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                user.id = rs.getInt("id");
                user.name = rs.getString("name");
                user.password = rs.getString("password");
                user.email = rs.getString("email");
                user.isadmin = rs.getBoolean("isadmin");
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public Customer getUserById(int id) {
        Customer user = new Customer();
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            String query = "SELECT * FROM customer WHERE id =" + id;
            Statement statement = conn.createStatement();
            ResultSet rs = null;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                user.id = rs.getInt("id");
                user.name = rs.getString("name");
                user.password = rs.getString("password");
                user.email = rs.getString("email");
                user.isadmin = rs.getBoolean("isadmin");
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public void updateUser(String name, String password, int id) {
         try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement statement = conn.prepareStatement("UPDATE CUSTOMER SET name=? ,password=? Where id=?");
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setInt(3, id);
            statement.executeUpdate();
            statement.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
