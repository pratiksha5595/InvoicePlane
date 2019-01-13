package com.invoiceplane.utlities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class dbCon {

    public static int getNoOfConnection =0;
    private Connection conn=null;
    private List<Statement> statementList = new ArrayList<Statement>();
    //private static Logger LOGGER = Logger.getLogger(DbCon.class.getName());

    public dbCon() throws Exception
    {
        getConnection();
    }

	/*public ResultSet getRecords(String strSQL,Statement s) throws Exception
	{
		//System.out.println(strSQL);
		try
		{
			s.executeQuery (strSQL);
			return s.getResultSet();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}*/

    public ResultSet getRecords(String strSQL) throws Exception
    {
        //LOGGER.debug("Fetching Data With Query: " + strSQL);
        try
        {
            Statement s = conn.createStatement();
            statementList.add(s);
            s = conn.createStatement();
            //System.out.println(strSQL);
            return s.executeQuery(strSQL);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    private void getConnection()throws Exception
    {
        //LOGGER.debug("Creating new Database Connection");

        ResourceBundle dbDetails = ResourceBundle.getBundle("dbSource");

        String ConnStr=dbDetails.getString("dbServer");
        String uname=dbDetails.getString("UserName");
        String pass=dbDetails.getString("Password");

        String connectionURL = ConnStr;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(connectionURL, uname, pass);
            getNoOfConnection++;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    public void dropConnection()
    {
        //LOGGER.debug("Dropping Database Connection");
        for (int i = 0; i < statementList.size(); i++)
        {
            try
            {
                statementList.get(i).close();
            }
            catch (SQLException e)
            { // LOGGER.error(e);
                //ignore
            }
        }

        try
        {
            if(!conn.isClosed())
            {
                getNoOfConnection--;
                //conn.
                conn.close();
                //System.out.println("Active DB Connections count is: " + getNoOfConnection);
            }
        }
        catch (Exception e)
        {//  LOGGER.error(e);
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public boolean Execute(String strSQL)
    {
        // LOGGER.debug("Executing SQL Query :" + strSQL);
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(strSQL);
            return true;
        }
        catch (Exception e)
        {  //LOGGER.error(e);
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
}
