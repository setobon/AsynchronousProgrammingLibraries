package services;

import models.Account;
import models.Response;

public interface AutomaticCashierService {

    public Response withdraw(Account account, double amount);
    public Response getBalanceOfAccount(Account account);
}
