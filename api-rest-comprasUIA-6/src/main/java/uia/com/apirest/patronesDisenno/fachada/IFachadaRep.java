package uia.com.apirest.patronesDisenno.fachada;

import uia.com.apirest.modelo.ItemReporteModelo;

import java.util.ArrayList;

public interface IFachadaRep {
    ArrayList<ItemReporteModelo> getItemsReporte(int id);
}
