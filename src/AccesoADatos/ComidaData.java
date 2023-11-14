
package AccesoADatos;

import Entidades.Comida;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ComidaData {
    private Connection conexion;

    public ComidaData() {
    conexion=Conexion.getConexion();
    }
    public void guardarComida(Comida comida){
        String sql="INSERT INTO comida( nombre, detalle, cantCalorias) VALUES (?,?,?)";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
            ps.executeUpdate();
            
             ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comida.setIdComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comida guardada exitosamente...");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Comida");
            Logger.getLogger(ComidaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void modificarComida(Comida comida){
        String sql = "UPDATE comida SET nombre=?,detalle=?,cantCalorias=?"
                + " WHERE idComida=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3,comida.getCantCalorias());
            ps.setInt(4, comida.getIdComida());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida modificada...");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Comida");
        }
    }
    public void eliminarComida(int idComida){
             String sql = "UPDATE comida SET estado=0 WHERE idComida=?";
       
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idComida);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida eliminada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla comida");
        }
    }
    public ArrayList<Comida> listarComidas(){
        ArrayList<Comida> listaC=new ArrayList();
        
        String sql="select * from comida where estado=1";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int idComida=rs.getInt("idComida");
                int calorias=rs.getInt("cantCalorias");
                String nombre=rs.getString("nombre");
                String detalle=rs.getString("detalle");
                boolean estado=rs.getBoolean("estado");
                Comida comida=new Comida(idComida,calorias, nombre, detalle,estado);
                listaC.add(comida);
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al acceder a la tabla comida");
            Logger.getLogger(ComidaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaC;
     
    }
    public ArrayList<Comida> buscarPorCalorias   (int calorias){
        ArrayList<Comida> listaC=new ArrayList<>();
        String sql="SELECT * FROM `comida` WHERE cantCalorias<?";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setInt(1, calorias);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int idComida=rs.getInt("idComida");
                calorias=rs.getInt("cantCalorias");
                String nombre=rs.getString("nombre");
                String detalle=rs.getString("detalle");
                boolean estado=rs.getBoolean("estado");
                Comida comida=new Comida(idComida,calorias, nombre, detalle,estado);
              
                listaC.add(comida);
            }
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ComidaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaC;  
    }
      
public Comida buscarComidaPorId   (int idComida){
     
        String sql="SELECT * FROM `comida` WHERE idComida=?";
        Comida comida=null;
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setInt(1, idComida);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int calorias=rs.getInt("cantCalorias");
                String nombre=rs.getString("nombre");
                String detalle=rs.getString("detalle");
//                boolean estado=rs.getBoolean("estado");
                comida=new Comida(calorias,nombre,detalle);
               
            }
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ComidaData.class.getName()).log(Level.SEVERE, null, ex);
        }
return comida;  
    }
}
