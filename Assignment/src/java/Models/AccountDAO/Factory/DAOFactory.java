/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.AccountDAO.Factory;

/**
 *
 * @author admin
 */
public class DAOFactory implements IDAOFactory{

    @Override
    public IAccountDAO AccountDAO() {
        return new AccountDAO();
    }
    
}
