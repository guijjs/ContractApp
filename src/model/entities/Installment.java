package model.entities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment{
  private LocalDate dueDate;
  private Double amount;

  public Installment(LocalDate dueDate, Double amount){
    this.dueDate = dueDate;
    this.amount = amount;
  };

  public LocalDate getDueDate(){
    return this.dueDate;
  };
  public void setDueDate(LocalDate newDueDate){
    this.dueDate = newDueDate; 
  };
  public Double getAmount(){
    return this.amount;
  };
  public void setAmount(Double amount){
    this.amount = amount;
  };
  @Override
  public String toString(){
    StringBuilder strMsg = new StringBuilder();
    strMsg.append(this.getDueDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    strMsg.append("- R$"+String.format("%.2f", this.getAmount()));
    return strMsg.toString();
  }
}
