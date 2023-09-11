public class User {
    private String name;
    private Integer age;
    public void setAge(Integer age) { this.age = age; };

    public void setName(String name) { this.name = name; };

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return this.name + ", возраст " + this.age + " лет";
    }

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
}
