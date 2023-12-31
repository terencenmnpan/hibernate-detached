package io.terence.hibernatedetached.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;
    private String text;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Version
    private Long version;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Test cloneMe(){
        Test test = new Test();
        test.setPk(this.getPk());
        test.setText(this.getText());
        return test;
    }
    @Override
    public String toString() {
        return "Test{" +
                "pk=" + pk +
                ", text='" + text + '\'' +
                ", version=" + version +
                '}';
    }
}
