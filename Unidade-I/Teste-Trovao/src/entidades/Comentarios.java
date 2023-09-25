package entidades;

public class Comentarios {
    private String post;

    public Comentarios(String post){
        this.post = post;
    }

    public String toString(){
        return this.post;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
