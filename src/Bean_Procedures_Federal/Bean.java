/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean_Procedures_Federal;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public abstract class Bean {

    public abstract Object[] getLlave();

    public abstract Object[] toArray();

    public abstract void setAtributos(Object[] obj);

    public abstract void actualizaDesc(Connection conn) throws SQLException;

}
