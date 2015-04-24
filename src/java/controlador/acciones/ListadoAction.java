package controlador.acciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class ListadoAction extends org.apache.struts.action.Action {
   
    private List<Departamento> listadepartamentos;
    private String mensaje;
    private static Connection conexion = null;
    
    public ListadoAction()
    {
        this.listadepartamentos = new ArrayList<Departamento>(); 
    }
    
    public void conectarSQL() throws SQLException
    {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        conexion =DriverManager.getConnection("jdbc:oracle:thin:@LOCALHOST:1521:XE","system", "javaoracle");
    }
  
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
         try
        {
            String consulta = "SELECT * FROM DEPT";
            this.conectarSQL();
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            setListadepartamentos(new ArrayList<Departamento>());
            
            while (rs.next())
            {
                Departamento d = new Departamento();
                d.setNumero(rs.getInt(("DEPT_NO")));
                d.setNombre(rs.getString(("DNOMBRE")));
                d.setLocalidad(rs.getString(("LOC")));
                getListadepartamentos().add(d);
            }
            rs.close();
        }catch (Exception ex)
        {
            System.out.print("[ERROR]: conectar");
        }
        
        request.setAttribute("mensaje",listadepartamentos);

        return mapping.findForward("listado");

    }
    
    public List<Departamento> getListadepartamentos() {
        return listadepartamentos;
    }

    public void setListadepartamentos(List<Departamento> listadepartamentos) {
        this.listadepartamentos = listadepartamentos;
    }
}
