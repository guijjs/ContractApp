import model.services.PaypalService;
import model.services.OnlinePaymentService;
import model.services.ContractService;
import model.entities.Contract;
import model.entities.Installment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Locale;
public class Application {
  public static void main(String[] args){
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    System.out.println("Entre os dados do contrato: "); 
    System.out.print("Número: ");
    int numCtrto = sc.nextInt();
    sc.nextLine();
    System.out.print("Data(dd/MM/yyyy): ");
    LocalDate dataCtrto = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    System.out.print("Valor total do Contrato: ");
    double valorCtrto = sc.nextDouble();
    System.out.print("Entre com número de parcelas: ");
    int months = sc.nextInt();
    Contract contrato = new Contract(numCtrto, dataCtrto, valorCtrto);
    ContractService processContract = new ContractService(new PaypalService());
    processContract.processContract(contrato, months);

    System.out.println("\nParcelas: ");
    contrato.installmentShow();

    sc.close();
  }
}
