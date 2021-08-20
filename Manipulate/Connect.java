package Manipulate;

import java.sql.Statement;

abstract class Connect {
    public abstract void doConnect();
    abstract String [] read();
    abstract void write(String result[]);
}
