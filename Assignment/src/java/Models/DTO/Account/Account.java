/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DTO.Account;

/**
 *
 * @author admin
 */
public class Account {
    private String AccountID;
    private String UserName;
    private String Password;
    private String FullName;
    private boolean Type;

    public Account(String AccountID, String UserName, String Password, String FullName, boolean Type) {
        this.AccountID = AccountID;
        this.UserName = UserName;
        this.Password = Password;
        this.FullName = FullName;
        this.Type = Type;
    }

    public Account() {
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public boolean isType() {
        return Type;
    }

    public void setType(boolean Type) {
        this.Type = Type;
    }
    
}
