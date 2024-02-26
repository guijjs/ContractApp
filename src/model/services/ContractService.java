package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService{
  private OnlinePaymentService paymentService;
  private Contract contract;
  
  public ContractService(OnlinePaymentService paymentService){
    this.paymentService = paymentService;
  }


  public void processContract(Contract contract, Integer months){
    
    //Serviço de pagamento.
    for(int i = 0; i<months; i++){
      LocalDate contractDueDate = contract.getDate();
      double installmentRealValue = (double) contract.getTotalValue()/months;
      installmentRealValue += paymentService.interest(installmentRealValue, i+1);
      installmentRealValue += paymentService.paymentFee(installmentRealValue);
      contractDueDate = contractDueDate.plusMonths(i+1);
      
      contract.getInstallments().add(new Installment(contractDueDate, installmentRealValue));
    }
  }
}
