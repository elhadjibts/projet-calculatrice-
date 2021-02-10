package action;

import com.opensymphony.xwork2.ActionSupport;

public class Formulaireconnexion extends ActionSupport {
    private String identifiant ;
    private String password ;

    public String getIdentifiant() {
       return identifiant;
    }

    public void setIdentifiant(String identifiant) {
      this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {

        if (this.identifiant == null || this.password == null)
        {
          // addFieldError("error","vous avez fait une erreur le champ est vide");
            return INPUT;
        }
        else if (this.identifiant.equals("") || this.password.equals(""))
        {
            addFieldError("error" , getText("champderror"));
            return INPUT ;
        }
        else
            return SUCCESS;

    }


}
