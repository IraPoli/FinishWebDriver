package model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "filters")
@XmlAccessorType(XmlAccessType.FIELD)
public class FiltersRozetka {

    @XmlElement(name = "filter")
    private List<FilterRozetka> filterRozetkasList;

    public List<FilterRozetka> getFilters() {
        return filterRozetkasList;
    }

    @Override
    public String toString() {
        return "FiltersRozetka{" +
                "filterRozetkasList=" + filterRozetkasList +
                '}';
    }
}
