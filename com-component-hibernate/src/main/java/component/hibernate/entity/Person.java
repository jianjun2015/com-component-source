package component.hibernate.entity;

/**
 * Created by wangjianjun on 2017/6/21.
 */
public class Person {

    private Integer personId;
    private String name;
    private Card card;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
