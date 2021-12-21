package utils;

import model.FiltersRozetka;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLToObject {
    public FiltersRozetka convert() {
        try {
            // File file = new File("src/main/resources/filterRozetka.xml");
            File file = new File("src/main/resources/filtersRozetka.xml");
            //JAXBContext jaxbContext = JAXBContext.newInstance(FilterRozetka.class);
            JAXBContext jaxbContext = JAXBContext.newInstance(FiltersRozetka.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (FiltersRozetka) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;

    }
}
