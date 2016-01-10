package api.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
    private int id;
    private String name;
    private String description;

    public Message(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
