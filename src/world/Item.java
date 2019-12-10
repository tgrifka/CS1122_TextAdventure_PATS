public class Item {
    private String name;
    private String use;
    private String description;

    public Item(String name, String use, String description){
        this.name = name;
        this.use = use;
        this.description = description;
    }

    public String getName(){ return name; }
    public String getUse(){ return use; }
    public String getDescription(){ return description; }
}
