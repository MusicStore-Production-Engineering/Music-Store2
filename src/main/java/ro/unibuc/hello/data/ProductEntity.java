package ro.unibuc.hello.data;


import org.springframework.data.annotation.Id;


public class ProductEntity {


    @Id
    private String id;


    private String name;
    private String description;
    private String categories;


    public ProductEntity() {}


    public ProductEntity(String name, String description, String categories) {
        this.name = name;
        this.description = description;
        this.categories = categories;
    }


    public String getName(){return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription(){return description;}
    public void setDescription(String description) {this.description= description;}
    public String getCategories(){return categories;}
    public void setCategories(String categories) {this.categories = categories;}


    @Override
    public String toString() {
        return String.format(
                "Product[id='%s', name='%s', description='%s', categories='%s']",
                id, name, description, categories);
    }


}
