import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {

        // SOLICITANDO NOME DO USUÁRIO COM VALIDAÇÕES
        String nomeUser;  //Como a variável está sendo declarada aqui, quando eu mandar o Scanner dentro do while, não precisarei do declarar de novo.
        try (var sc = new Scanner(System.in)) {
            System.out.println("Digite seu nome: ");

            //Nome do cliente não poderá ser nulo ou vazio, e deverá ser convertido para letras maíscula.
            while (true) {
                nomeUser = sc.nextLine();
                //isBlank é um boolean que verifica se a String é vazia ou contem apenas espaços
                //isBlank ! isEmpty, pois isEmpty verifica se está vazio, mas não sabe se só tem espaços
                if (nomeUser.isBlank()) {
                    System.out.println("Erro: O nome não pode ser vazio. Por favor, Tente novamente e insira seu nome.");
                } else {
                    break;
                }
            }
            // Depois de verificar se o campo foi preenchido corretamente, formatamos para UpperCase.
            String nomeUserUpper = nomeUser.toUpperCase();


            // SOLICITANDO NÚMERO DE CONTA E DE AGÊNCIA
            System.out.println("Digite o número da sua conta: ");
            int numeroConta = sc.nextInt();
            sc.nextLine(); //Gemini, isso aqui limpa o buffer?
            System.out.println("Digite o número da sua Agência: ");
            var agenciaConta = sc.next(); // String
            sc.nextLine();


            float saldoConta;
            // SOLICITANDO SALDO DO USUÁRIO COM VALIDAÇÕES
            while (true) {
                System.out.println("Digite seu saldo: ");
                try {
                     saldoConta = sc.nextFloat();

                    //verifica se o saldo é positivo ou zero
                    if (saldoConta >= 0) {
                        break;
                    } else {
                        System.out.println("Erro: Não é possível criar uma conta com saldo negativo.");
                    }
                } catch (InputMismatchException e) {
                    //pegamos o erro quando o usuário não digita um número
                    System.out.println("Erro: Valor inválido. Por favor, digite um número.");
                    sc.nextLine(); //isso limpa o buffer ne??
                }
            }

            //Melhorias de UX
            //Informa ao usuário o momento exato que ele conseguiu realizar o cadastro com sucesso.

            System.out.println("\n------------------------------------");
            System.out.println("✅ Conta criada com sucesso!");

            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern(
                    "'Cadastro realizado às' HH:mm:ss 'do dia' dd 'de' MMMM 'de' yyyy.",
                    new Locale("pt", "BR")
            );
            String mensagemCadastro = agora.format(formatador);
            System.out.println(mensagemCadastro);
            System.out.println("------------------------------------");


            if (saldoConta > 0) {
                System.out.printf("Olá, %s, obrigado por criar uma conta em nosso banco. Sua agência é %s, conta %d e seu saldo de %.2f já está disponível para saque.\n",
                        nomeUserUpper, agenciaConta, numeroConta, saldoConta);
            }else{
                System.out.printf("Olá, %s, obrigado por criar uma conta em nosso banco. Sua agência é %s, conta %d e seu saldo é de %.2f. Deposite algum valor para poder sacar.\n",
                        nomeUserUpper, agenciaConta, numeroConta, saldoConta);
            }
        }
    }
}


