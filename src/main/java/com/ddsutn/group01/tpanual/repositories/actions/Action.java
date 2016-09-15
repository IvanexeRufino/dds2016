package com.ddsutn.group01.tpanual.repositories.actions;

public interface Action {
    void precondition();
    void postcondition(String criteria, int result, String nombre);
}
