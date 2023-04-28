package ro.unibuc.hello.dto;

public class Product{

    private String name;
    private String description;
    private String categories;

    public Product() {
    }

    public Product(String name, String description, String categories) {

        this.name = name;
        this.description = description;
        this.categories =  categories;
    }



    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getCategories() {
        return categories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}