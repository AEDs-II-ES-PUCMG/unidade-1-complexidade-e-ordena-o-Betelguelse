import java.util.Comparator;

/**
 * Critério B - Volume Total de Itens (crescente).
 * Desempate 1: Data do Pedido.
 * Desempate 2: Código Identificador do pedido.
 */
public class ComparadorCriterioB implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        int totalItens1 = o1.getTotalItens();
        int totalItens2 = o2.getTotalItens();
        if (totalItens1 != totalItens2) {
            return totalItens1 - totalItens2;
        }
        
        if (!o1.getDataPedido().equals(o2.getDataPedido())) {
            if (o1.getDataPedido().isBefore(o2.getDataPedido())) {
                return -1;
            } else {
                return 1;
            }
        }
        
        return o1.getIdPedido() - o2.getIdPedido();
    }
}
