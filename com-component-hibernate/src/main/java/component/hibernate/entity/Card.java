package component.hibernate.entity;

/**
 * Created by wangjianjun on 2017/6/21.
 */
public class Card {

    private Integer cardId;
    private String name;
    private Person person;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
