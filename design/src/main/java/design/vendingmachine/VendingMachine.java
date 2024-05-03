package design.vendingmachine;

import java.util.List;
import java.util.Map;

public class VendingMachine {
}

abstract class Item {
    int itemId;
    double rate;
}

interface VendingMachineState {

    boolean insertMoney(double money);

    boolean selectItem(int itemCode);

    Object dispense();
}

class NoMoneyState implements VendingMachineState {
    VendingMachineExecutor e;

    public NoMoneyState(VendingMachineExecutor e) {
        this.e = e;
    }

    @Override
    public boolean insertMoney(double money) {
        e.setMoney(money);
        e.setState(e.selectItemState);
        return true;
    }

    @Override
    public boolean selectItem(int itemCode) {
        return false;
    }

    @Override
    public Item dispense() {
        return null;
    }
}

class SelectItemState implements VendingMachineState {
    VendingMachineExecutor e;

    public SelectItemState(VendingMachineExecutor e) {
        this.e = e;
    }

    @Override
    public boolean insertMoney(double money) {
        return false;
    }

    @Override
    public boolean selectItem(int itemCode) {
        if (e.getItems().containsKey(itemCode) && e.getItems().get(itemCode).size()>0) {
            if(e.getMoney()==e.getItems().get(itemCode).get(0).rate) {
                e.setSelectedItem(itemCode);
                return true;
            }
            if(e.getMoney()>e.getItems().get(itemCode).get(0).rate) {
                e.setSelectedItem(itemCode);
                e.setState(e.returnChange);
                return true;
            } else {
                e.setState(e.insufficientMoney);
                return false;
            }
        }
        return false;
    }

    @Override
    public Item dispense() {
        return null;
    }
}


class ReturnChangeState implements VendingMachineState {
    VendingMachineExecutor e;

    public ReturnChangeState(VendingMachineExecutor e) {
        this.e = e;
    }

    @Override
    public boolean insertMoney(double money) {
        return false;
    }

    @Override
    public boolean selectItem(int itemCode) {
        return false;
    }

    @Override
    public Double dispense() {
        e.setState(e.dispenseItem);
        return e.getMoney()- e.getItems().get(e.getSelectedItem()).get(0).rate ;
    }
}

class InsufficientMoneyState implements VendingMachineState {
    VendingMachineExecutor e;

    public InsufficientMoneyState(VendingMachineExecutor e) {
        this.e = e;
    }

    @Override
    public boolean insertMoney(double money) {
        return false;
    }

    @Override
    public boolean selectItem(int itemCode) {
        return false;
    }

    @Override
    public Double dispense() {
        return e.getMoney();
    }
}

class DispenseItem implements VendingMachineState {
    VendingMachineExecutor e;

    public DispenseItem(VendingMachineExecutor e) {
        this.e = e;
    }

    @Override
    public boolean insertMoney(double money) {
        return false;
    }

    @Override
    public boolean selectItem(int itemCode) {
        return false;
    }

    @Override
    public Item dispense() {
        Item i = e.getItems().get(e.getSelectedItem()).remove(0);
        e.setState(e.noMoney);
        return i;
    }
}

class VendingMachineExecutor {
    private Map<Integer, List<Item>> items;
    private int selectedItem;
    private double money;

    VendingMachineState noMoney;
    VendingMachineState selectItemState;
    VendingMachineState returnChange;
    VendingMachineState insufficientMoney;
    VendingMachineState dispenseItem;

    private VendingMachineState state;

    public Map<Integer, List<Item>> getItems() {
        return items;
    }

    public void setItems(Map<Integer, List<Item>> items) {
        this.items = items;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public VendingMachineState getState() {
        return state;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public int getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
    }
}

abstract class Actor {

}

class User extends Actor {

}

class Admin extends Actor {

    boolean addItem(Item item) {
        return true;
    }

    boolean removeItem(int itemId) {
        return true;
    }

}
