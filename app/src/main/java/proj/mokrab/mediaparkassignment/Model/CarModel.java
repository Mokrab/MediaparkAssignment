package proj.mokrab.mediaparkassignment.Model;

public class CarModel {
    private Integer id;
    private String title;
    private String photoUrl;

    public CarModel(Integer id, String title, String photoUrl) {
        this.id = id;
        this.title = title;
        this.photoUrl = photoUrl;
    }

    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getPhotoUrl() {
        return photoUrl;
    }

}
