package action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.List;

public class CalculatriceStatique extends ActionSupport {
    private double operande1;

    public double getOperande1() {
        return operande1;
    }

    public void setOperande1(double operande1) {
        this.operande1 = operande1;
    }

    public double getOperande2() {
        return operande2;
    }

    public void setOperande2(double operande2) {
        this.operande2 = operande2;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    private double operande2;

    public double getResultat() {
        return resultat;
    }

    public void setResultat(double resultat) {
        this.resultat = resultat;
    }

    private double resultat;
    private String typeOperation ;

    public List<String> getListDeMesOperations(){
        return Arrays.asList("Somme","Multiplication","Division","Soustraction");
    }

    @Override
    public String execute() throws Exception {
      switch(typeOperation)

      {
          case "Somme":
              this.resultat=this.operande1+this.operande2;
              break;
          case "Multiplication":
              this.resultat=this.operande1*this.operande2;
              break;
          case "Soustraction":
              this.resultat=this.operande1-this.operande2;
          break;
          case "Division":
              this.resultat=this.operande1/this.operande2;
              break;
      }
      return SUCCESS;


    }

    @Override
    public void validate() {

        if (typeOperation.equals("Division")){
            if (this.operande2==0){
                addFieldError("errordivision" , getText("errordecalcul"));
            }


        }


    }
}

