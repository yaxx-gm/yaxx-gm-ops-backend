package org.br.yaxx.backend.utils.languagues;

public class English implements ILanguage {

    @Override
    public String getUserAlreadyExist() {
        return "User already exist";
    }

    @Override
    public String getUserInsertDontWork() {
        return "Insert user dont work";
    }

    @Override
    public String getUserSuccessfulInsert() {
        return "User successful insert";
    }

    @Override
    public String getUserNoExist() {
        return "User no exist";
    }
}
