package Manipulate;

import java.sql.Statement;

abstract class Connect {
    static Statement stmt;
    public void setStatement(Statement statement) {
        stmt = statement;
    }
    abstract String [] read();
    abstract void write(String result[]);
}


interface reader{
    String[] readNext();
    String[] readPrevious();
    String[] readLast();
    boolean updateRow(String result[]);
    boolean deleteRow()
    ;
}