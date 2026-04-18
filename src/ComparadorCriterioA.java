import java.util.Comparator;

/**
 * Critério A - Valor Final do Pedido (crescente).
 * Desempate 1: Volume Total de Itens (quantProdutos).
 * Desempate 2: Código Identificador do primeiro item do pedido.
 */
public class ComparadorCriterioA implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        double diff = o1.valorFinal() - o2.valorFinal();
        if (diff != 0) {
            return (diff > 0) ? 1 : -1;
        }
        
        int totalItens1 = o1.getTotalItens();
        int totalItens2 = o2.getTotalItens();
        if (totalItens1 != totalItens2) {
            return totalItens1 - totalItens2;
        }
        
        return o1.getIdPrimeiroProduto() - o2.getIdPrimeiroProduto();
    }
}
