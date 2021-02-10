package action;

import com.opensymphony.xwork2.ActionSupport;
import modele.CalculatriceDynamiqueDuFutur;
import modele.CalculatriceDynamiqueDuFuturImpl;
import org.apache.struts2.interceptor.ApplicationAware;

import java.util.Collection;
import java.util.Map;

public class CalculatriceDynamique extends ActionSupport implements ApplicationAware {
    private double operationA;
    private double operationB;
    private String typeOperation;
    private CalculatriceDynamiqueDuFutur facade ;
    private double resultat ;

    public double getResultat() {
        return resultat;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public double getOperationA() {
        return operationA;
    }

    public void setOperationA(double operationA) {
        this.operationA = operationA;
    }

    public double getOperationB() {
        return operationB;
    }

    public void setOperationB(double operationB) {
        this.operationB = operationB;
    }

    @Override
    public String execute() throws Exception {

        this.resultat  = this.facade.doCalcul(typeOperation,operationA , operationB) ;

        return SUCCESS;
    }

    @Override
    public void setApplication(Map <String, Object> map) {
        this.facade= (CalculatriceDynamiqueDuFutur) map.get("mesfacades");
    if ( this.facade == null){

        this.facade=new CalculatriceDynamiqueDuFuturImpl();
        map.put("mesfacades",this.facade) ;
    }
    }


    public Collection<String> getListeCalculDynamique (){
        return this.facade.getOperations() ;
    }
    public long getCompteur() {
        return this.facade.getValeurCompteur() ;
    }


    @Override
    public void validate() {

        if (typeOperation.equals("Division")){
            if (this.operationB==0){
                addFieldError("errordivision" , getText("errordecalcul"));
            }


        }


    }
}


