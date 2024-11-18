/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.Account;

/**
 *
 * @author admin
 */
public class AccountError {
    private String AccountIDError;
    private String UserNameError;
    private String PasswordError;
    private String FullNameError;
    private boolean TypeError;
    private String duplicateAccoutID;

    public AccountError() {
    }

    public AccountError(String AccountIDError, String UserNameError, String PasswordError, String FullNameError, boolean TypeError, String duplicateAccoutID) {
        this.AccountIDError = AccountIDError;
        this.UserNameError = UserNameError;
        this.PasswordError = PasswordError;
        this.FullNameError = FullNameError;
        this.TypeError = TypeError;
        this.duplicateAccoutID = duplicateAccoutID;
    }

    public String getAccountIDError() {
        return AccountIDError;
    }

    public void setAccountIDError(String AccountIDError) {
        this.AccountIDError = AccountIDError;
    }

    public String getUserNameError() {
        return UserNameError;
    }

    public void setUserNameError(String UserNameError) {
        this.UserNameError = UserNameError;
    }

    public String getPasswordError() {
        return PasswordError;
    }

    public void setPasswordError(String PasswordError) {
        this.PasswordError = PasswordError;
    }

    public String getFullNameError() {
        return FullNameError;
    }

    public void setFullNameError(String FullNameError) {
        this.FullNameError = FullNameError;
    }

    public boolean isTypeError() {
        return TypeError;
    }

    public void setTypeError(boolean TypeError) {
        this.TypeError = TypeError;
    }

    public String getDuplicateAccoutID() {
        return duplicateAccoutID;
    }

    public void setDuplicateAccoutID(String duplicateAccoutID) {
        this.duplicateAccoutID = duplicateAccoutID;
    }
    
    
}
