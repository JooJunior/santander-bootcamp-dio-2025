import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        /* ToDo
         * Conhecer e importar classe scanner
         * Exibir msg pro usuário
         * obter pela classe scanner, os valores digitados no terminal
         * exibir a mensagem final da conta criada
         * Adicional que poderia ser implementado: tratar erros para nome com números e caracteres especiais;
         * Adicional que poderia ser implementado: tratar erros para saldo com letras;
         */

        var sc =  new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        var nomeUser = sc.nextLine();
        String nomeUserUpper = nomeUser.toUpperCase();

        System.out.println("Digite o número da sua conta: ");
        int numeroConta = sc.nextInt();
        System.out.println("Digite o número da sua Agência: ");
        var agenciaConta = sc.next(); // String
        System.out.println("Digite seu saldo: ");
        float saldoConta = sc.nextFloat();
        sc.nextLine(); //isso limpa o buffer ne??

        System.out.printf("Olá, %s, obrigado por criar uma conta em nosso banco. Sua agêcnia é %s, conta %d e seu %.2f já está disponível para saque.",
                nomeUserUpper, agenciaConta, numeroConta, saldoConta );
        // %d quando for numero e %s quando for string
        // Para double, usamos o formatador %f (floating point)
        // %.2f formata para exibir apenas 2 casas decimais
    }
}
