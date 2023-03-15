package implementaciones;

import entidades.Caja;
import entidades.Cliente;
import entidades.Gasto;
import fachada.FachadaDAO;
import interfaces.IConexionBD;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import interfaces.IControlGastos;


public class ControlGastos implements IControlGastos {

    
    private final FachadaDAO fachadaDAO;

    public ControlGastos(FachadaDAO fachadaDAO) {
        this.fachadaDAO=fachadaDAO;
    }

    @Override
    public int agregar(Gasto gasto) {
       return this.fachadaDAO.agregarGasto(gasto);
    }

    @Override
    public Gasto consultar(int id) {
        return this.fachadaDAO.consultar(id);
    }

    @Override
    public List<Gasto> consultarTodas() {
     return this.fachadaDAO.consultarTodas();
    }

    @Override
    public List<Gasto> buscarEntre(Calendar inicio, Calendar fin) {
    return this.fachadaDAO.buscarGastosEntreFechas(inicio, fin);
    }

}
