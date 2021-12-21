package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "filter")
@XmlAccessorType(XmlAccessType.FIELD)
public class FilterRozetka {
    private String itemName;
    private String brand;
    private int sumLimit;
    private int id;

    public String getItemName() {
        return itemName;
    }

    public int getSumLimit() {
        return sumLimit;
    }

    public String getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "filterRozetka{" +
                "itemName='" + itemName + '\'' +
                ", sumLimit=" + sumLimit +
                '}';
    }
}
