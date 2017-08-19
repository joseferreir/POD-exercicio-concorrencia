/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.atividade.repositorio;

import br.edu.ifpb.pod.atividade.entyty.Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose2
 */
public class RepositorioDados implements Repositorio<Dados> {

    private Connection conn;
    private final String host = "url=jdbc:postgresql://localhost:5432/pod-rmi";

    @Override
    public void add(Dados obj) {
        try {
           
            String query = "INSERT INTO  TB_DADOS(id,who, CREATED__IN ) VALUES(?,?,?)";
            this.conn = ConnectionFactory.of(host).getConnection();
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, obj.getID());
            stat.setString(2, obj.getWHO());
            stat.setLong(3, obj.getCREATED__IN());

            if (stat.executeUpdate() > 0) {

                
            }
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Dados find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isdadosrepitidos() {
        try {
            boolean result = false;
            String query = "SELECT ID, COUNT( id ) n FROM TB_DADOS\n"
                    + "GROUP BY ID\n"
                    + "ORDER BY n DESC \n"
                    + "LIMIT 2";
            this.conn = ConnectionFactory.of(host).getConnection();
            PreparedStatement stat = conn.prepareStatement(query);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
            if (rs.getInt("n")>1) {

                result = true;
                break;
            }
            }
            conn.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioDados.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

        

    


}
