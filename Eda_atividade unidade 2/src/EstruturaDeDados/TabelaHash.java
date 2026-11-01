package EstruturaDeDados;
import java.util.HashMap;
import java.util.Map;

public class TabelaHash {
    public int[] twoSum(int[] nums, int target) {
        // Criamos um HashMap para armazenar os números e seus índices
        Map<Integer, Integer> numMap = new HashMap<>();
        
        // Percorremos o array uma única vez
        for (int i = 0; i < nums.length; i++) {
            // Calculamos o complemento que precisamos encontrar
            int complement = target - nums[i];
            
            // Se o complemento já existe no HashMap, encontramos nossa resposta
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            
            // Se não encontramos, adicionamos o número atual e seu índice ao HashMap
            numMap.put(nums[i], i);
        }
        
        // Se não encontrarmos nenhuma solução, retornamos um array vazio
        return new int[0];
    }
} 