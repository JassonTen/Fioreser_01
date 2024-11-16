package www.fioreser.com.pe.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import www.fioreser.com.pe.app.domain.ItemCarrito;

/**
 *
 * @author FENIX
 */
public class CarritoService {

    private List<ItemCarrito> itemCarrito;
    private HashMap<Integer, ItemCarrito> itemHashMap;

    public CarritoService() {
        this.itemHashMap = new HashMap<>();
        this.itemCarrito = new ArrayList<>();
    }

    public void addItemCart(Integer idPr,
            String nombrePr,
            Integer quantity,
            BigDecimal precio) {

        ItemCarrito itemCarrit = new ItemCarrito(idPr,
                nombrePr, quantity, precio);
        itemHashMap.put(itemCarrit.getIdPrC(), itemCarrit);
        fillList();
    }

    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCarrito itemCarrit : itemCarrito) {
            total = total.add(itemCarrit.getTotalPriceItem());

        }
        return total;
    }

    //elimina el item del carrito por Id
    public void removeItemCart(Integer idPrC) {
        itemHashMap.remove(idPrC);
        fillList();
    }
    
    //limpia el arreglo temporal de productos añadidos al carrito
    public void removeAllItemsCart() {
        itemHashMap.clear();
        itemCarrito.clear();
    }
    
    private void fillList() {
        itemCarrito.clear();
        itemHashMap.forEach(
                (Integer, itemCart) -> itemCarrito.add(itemCart)
        );
    }
    
    //para ver en consola 
    public List<ItemCarrito> getItemCarts(){
        return  itemCarrito;
    }
}
