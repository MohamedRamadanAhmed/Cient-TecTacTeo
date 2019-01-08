
package model;


public class Pojo {
    private String name;
    private String Password;

    public Pojo(String name, String Password) {
        this.name = name;
        this.Password = Password;
    }

    public Pojo() {
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return Password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
