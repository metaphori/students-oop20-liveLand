package model.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;

public class Profit implements Activity {

    private final String name;
    private int totMoney;
    private int totPeople;
    private final int min;
    private final int max;
    private final ActivityType activityType;
    private final List<PersonTicket> personList = new ArrayList<>();

    public Profit(final String name, final int min, final int max, final ActivityType activityType) {
        this.name = name;
        this.activityType = activityType;
        this.min = min;
        this.max = max;
    }

    public Profit(final String name, final int min, final int max, final ActivityType activityType, final int visitors) {
        this.name = name;
        this.activityType = activityType;
        this.min = min;
        this.max = max;
        this.totPeople = visitors;
    }

    public final void addPerson(final PersonTicket person) {
        personList.add(person);
        amount();
        totPeople++;
    }

    public final void removePerson() {
        personList.clear();
    }

    public final void setProfit(final int money) {
        this.totMoney = money;
    }

    public final int getProfit() {
        return totMoney;
    }

    public final int getTotPeople() {
        return totPeople;
    }

    public final void amount() {
        int money;
        final Random r = new Random();
        do {
            money = r.nextInt(max);
        } while (money > min);

        setProfit(getProfit() + money);

    }

    public final ActivityType getActivityType() {
        return this.activityType;
    }

    public final String getName() {
        return this.name;
    }

    public final List<PersonTicket> getPeopleList() {
        return personList;

    }

}
