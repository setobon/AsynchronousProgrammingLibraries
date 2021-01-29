package services.impl;

import models.Account;
import models.Data;
import models.Response;

import java.util.ArrayList;
import java.util.List;

public class AutomaticCashierService implements services.AutomaticCashierService {

    private static final String SUCCESS = "SUCCESS";
    private static final String SUCCESS_CODE = "000";
    private static final String SUCCESS_MESSAGE = "SUCCESSFUL TRANSACTION";

    private static final String ERROR = "ERROR";
    private static final String ERROR_CODE = "001";
    private static final String ERROR_MESSAGE = "INVALID AMOUNT";

    @Override
    public Response withdraw(Account account, double amount) {
        System.out.println("withdraw process has start");

       if(isValidAmount(account, amount)) {
           sustractWithdrawalOfBalanceAccount(account, amount);

           return new Response(SUCCESS, SUCCESS_CODE, SUCCESS_MESSAGE, getResponseDataSuccess(account));
       }

       return new Response(ERROR, ERROR_CODE, ERROR_MESSAGE, new ArrayList<Data>());
    }

    @Override
    public Response getBalanceOfAccount(Account account) {
        return new Response(SUCCESS, SUCCESS_CODE, SUCCESS_MESSAGE, getResponseDataSuccess(account));
    }

    private List<Data> getResponseDataSuccess(Account account) {
        List<Data> data= new ArrayList<>();
        data.add(new Data("Account number", account.getNumber()));
        data.add(new Data("Funds", Double.toString(account.getBalance())));
        return data;
    }

    private boolean isValidAmount(Account account, double amount) {
        return account.getBalance()< amount || amount >=0;
    }

    private void sustractWithdrawalOfBalanceAccount(Account account, double amount) {
        account.setBalance(account.getBalance() - amount);
    }
}
