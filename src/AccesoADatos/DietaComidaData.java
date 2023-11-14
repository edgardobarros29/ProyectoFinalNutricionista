
package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DietaComidaData {
             private Connection conexion=null;
   
    public DietaComidaData() {
    conexion=Conexion.getConexion();
   
    }
    
 
        public void agregarComidaAUnaDieta(int idDieta, ArrayList<Integer> idComidas) {
        String sql = "INSERT INTO dietacomida ( idComida,idDieta) VALUES (?, ?)";
        PreparedStatement ps;
           try {
            ps = conexion.prepareStatement(sql);
            for (int idComida : idComidas) {
                ps.setInt(2, idDieta);
                ps.setInt(1, idComida);
               ps.addBatch(); 
                 int exito=ps.executeUpdate();
             if(exito==1){JOptionPane.showMessageDialog(null, "comida agregada a la lista...");
              }    
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta-comida"+ex);
        }
    }
      
         public void agregarComidaAUnaDieta(int idComida,int idDieta) {
        String sql = "INSERT INTO dietacomida ( idComida,idDieta) VALUES (?, ?)";
        PreparedStatement ps;
           try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idComida);    
            ps.setInt(2, idDieta);
                
               ps.executeUpdate(); 
                 int exito=ps.executeUpdate();
             if(exito==1){JOptionPane.showMessageDialog(null, "comida agregada a la lista...");
              }    
            
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta-comida"+ex);
        }
    }   
        
       public void borrarComidasDeUnaDieta(int idDieta, int idComida)  {
        String sql = "DELETE FROM dietacomida WHERE idDieta = ? AND idComida=?";
        PreparedStatement ps;
       
        try {
            
            ps = conexion.prepareStatement(sql);
                 ps.setInt(1, idDieta);
                 ps.setInt(2, idComida);
                 int exito=ps.executeUpdate();
              if(exito==1){JOptionPane.showMessageDialog(null, "comida eliminda");
              }
           
               } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dietacomida");
        }
        
    }     

    public List<String> listarNombresComidasPorIdDieta(int idDieta) {
        List<String> nombresComidas = new ArrayList<>();

        String sql = "SELECT comida.nombre " +
                     "FROM dietaComida " +
                     "JOIN comida ON dietaComida.idComida = comida.idComida " +
                     "WHERE dietaComida.idDieta = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                nombresComidas.add(nombre);
            }
            ps.close();
        } catch (SQLException e) {
                     JOptionPane.showMessageDialog(null, "error al acceder a la tabla dietacomida");
        }

        return nombresComidas;
    }
     public ArrayList <Comida> listarComidas(int idDieta){
        ArrayList <Comida> comidas = new ArrayList();
        String sql = "SELECT  c.idComida, nombre, detalle, cantCalorias FROM dietacomida d INNER JOIN comida c ON d.idComida = c.idComida WHERE d.idDieta=?";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                int idComida = rs.getInt("idComida");
                String nombre = rs.getString("nombre");
                String detalle= rs.getString("detalle");
                int cantCalorias = rs.getInt("cantCalorias");
                Comida c = new Comida(idComida, cantCalorias, nombre, detalle, true );
                comidas.add(c);
            }
            ps.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dietacomida");
        }
        return comidas;
    }
}
