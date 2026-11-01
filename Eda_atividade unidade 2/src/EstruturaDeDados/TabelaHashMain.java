package EstruturaDeDados;
public class TabelaHashMain {
    public static void main(String[] args) {
        // Criamos uma instância do TabelaHash
        TabelaHash solution = new TabelaHash();
        
        // Teste 1: Caso básico
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Teste 1:");
        System.out.println("Array: [2, 7, 11, 15]");
        System.out.println("Target: " + target1);
        System.out.println("Resultado: [" + result1[0] + ", " + result1[1] + "]");
        
        // Teste 2: Caso com números repetidos
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("\nTeste 2:");
        System.out.println("Array: [3, 2, 4]");
        System.out.println("Target: " + target2);
        System.out.println("Resultado: [" + result2[0] + ", " + result2[1] + "]");
        
        // Teste 3: Caso com números iguais
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("\nTeste 3:");
        System.out.println("Array: [3, 3]");
        System.out.println("Target: " + target3);
        System.out.println("Resultado: [" + result3[0] + ", " + result3[1] + "]");
    }
} 