package uia.com.apirest.patronesDisenno.fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uia.com.apirest.compras.GestorCompras;
import uia.com.apirest.modelo.*;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public abstract class FachadaModelRep implements IFachadaRep {
    GestorCompras miGestorCompras;

    private HashMap<Integer, ReporteModelo> misReportes;
    private ArrayList<ReporteModelo> miModeloReportes = new ArrayList<ReporteModelo>();

    @Autowired
    public FachadaModelRep(GestorCompras gestorCompras)
    {
        this.miGestorCompras = gestorCompras;
        misReportes = this.miGestorCompras.getMisReporteNivelStock();
    }


    public ArrayList<ReporteModelo> itemsReporte(int id)
    {
            for (int i = 0; i < misReportes.size(); i++) {
                //   public ReporteModelo(int id, String name, String codigo, int vendedor, int clasificacionVendedor, double total, int entrega)
                ReporteModelo item = new ReporteModelo(misReportes.get(i).getId()
                                        , misReportes.get(i).getName()
                        , misReportes.get(i).getCodigo()
                        , misReportes.get(i).getVendedor()
                        , misReportes.get(i).getClasificacionVendedor()
                        , misReportes.get(i).getTotal()
                        , misReportes.get(i).getEntrega());
                            if (misReportes.get(i).getItems() != null) {
                    ArrayList<ItemReporteModelo> itemsReporte = new ArrayList<ItemReporteModelo>();
                    for (int j = 0; j < misReportes.get(i).getItems().size(); j++) {
                        //ItemReporteModelo(int cantidad, double valorUnitario, double subtotal, double total)
                        ItemCotizacionModelo nodo = new ItemCotizacionModelo(
                                misReportes.get(i).getItems().get(j).getCantidad()
                                , misReportes.get(i).getEntrega()
                                , misReportes.get(i).getItems().get(j).getExistencia()
                                , misReportes.get(i).getTotal()
                                , misReportes.get(i).getItems().get(j).getName()
                                , misReportes.get(i).getItems().get(j).getClasificacion()
                                , misReportes.get(i).getItems().get(j).getId()
                                , misReportes.get(i).getItems().get(j).getCodigo()
                        );
                        if(nodo.getId()==id)
                            miModeloReportes.add(item);
                    }
                }
            }

            return this.miModeloReportes;

    }

    public ArrayList<ItemReporteModelo> itemsSolicitud()
    {
        return null;
    }

    public ArrayList<ItemReporteModelo> itemsReporte()
    {
        return null; //this.reporte.getItems();
    }

    public abstract ArrayList<ItemReporteModelo> getIemsReporte();
}
