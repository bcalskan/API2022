package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {
    /*
    1) Tüm keyler icin private variable´lar olustur
    2) Tüm parametrelerle ve parametresiz constructor´lari olustur
    3) Getters and Setters´lari olustur
    4) toString() methodu olustur
     */

    //1) Tüm keyler icin private variable´lar olustur
    private Integer userId;
    private String title;
    private Boolean completed;

    //2) Tüm parametrelerle ve parametresiz constructor´lari olustur
    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }

    //3) Getters and Setters´lari olustur
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //4) toString() methodu olustur
    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    //Farkli key-value ikililerinin uyusmazligi @JsonIgnoreProperties(ignoreUnknown = true)
    //anotation´ini Pojo Class´in basina yazarak cözülebilir



}
