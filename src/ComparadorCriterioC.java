import java.util.Comparator;

/**
 * Critério C - Índice de Economia (decrescente).
 * O índice de economia é a diferença entre o valor de catálogo atual e o valor efetivamente pago.
 * Desempate 1: Valor Final do Pedido (crescente).
 * Desempate 2: Código Identificador do pedido (crescente).
 */
public class ComparadorCriterioC implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        double indiceEconomia1 = o1.indiceEconomia();
        double indiceEconomia2 = o2.indiceEconomia();
        double diff = indiceEconomia2 - indiceEconomia1;
        if (diff != 0) {
            return (diff > 0) ? 1 : -1;
        }
        
        double diffValor = o1.valorFinal() - o2.valorFinal();
        if (diffValor != 0) {
            return (diffValor > 0) ? 1 : -1;
        }
        
        return o1.getIdPedido() - o2.getIdPedido();
    }
}
