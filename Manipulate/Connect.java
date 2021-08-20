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
