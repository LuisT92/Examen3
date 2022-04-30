package uia.com.apirest.patronesDisenno.fachada;

import org.springframework.stereotype.Component;
import uia.com.apirest.compras.GestorCompras;
import uia.com.apirest.modelo.ItemReporteModelo;

import java.util.ArrayList;

@Component
public class FachadaReportes extends FachadaModelRep {

    public FachadaReportes(GestorCompras gestorCompras) {
        super(gestorCompras);
    }

    @Override
    public ArrayList<ItemReporteModelo> getIemsReporte(){
        return this.itemsReporte();
    }

    @Override
    public ArrayList<ItemReporteModelo> getItemsReporte(int id) {
        return null;
    }
}
