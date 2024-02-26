package model.entities;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import model.entities.Installment;
public class Contract{
  private Integer number;
  private LocalDate date;
  private Double totalValue;
  private List<Installment> installments;

  public Contract(Integer number, LocalDate date, Double totalValue){
    this.number = number;
    this.date = date;
    this.totalValue = totalValue;
    this.installments = new ArrayList<>();
  };
  public List<Installment> getInstallments(){
    return this.installments;
  }
  public Integer getNumber(){
    return this.number;
  };
  public LocalDate getDate(){
    return this.date;
  };
  public Double getTotalValue(){
    return this.totalValue;
  };

  public void setNumber(Integer number){
    this.number = number;
  };
  public void setDate(LocalDate date){
    this.date = date;
  };
  public void totalValue(Double totalValue){
    this.totalValue = totalValue;
  }
  public void installmentShow(){
    for(Installment i : this.installments){
      System.out.println(i);
    }
  }
}
