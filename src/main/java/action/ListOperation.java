package action;

import com.opensymphony.xwork2.ActionSupport;
import modele.CalculatriceDynamiqueDuFutur;
import modele.CalculatriceDynamiqueDuFuturImpl;
import org.apache.struts2.interceptor.ApplicationAware;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ListOperation extends ActionSupport implements ApplicationAware {

    private CalculatriceDynamiqueDuFutur facade ;

    public List<String> getListDeMesOperations(){
        return Arrays.asList("Somme","Multiplication","Division","Soustraction");
    }

    public Collection <String> getListeCalculDynamique (){
        return this.facade.getOperations() ;
    }
    @Override
    public void setApplication(Map<String, Object> map) {
        this.facade= (CalculatriceDynamiqueDuFutur) map.get("mesfacades");
        if ( this.facade == null){

            this.facade=new CalculatriceDynamiqueDuFuturImpl();
            map.put("mesfacades",this.facade) ;
        }
    }
}
