package desafiowcc.desafio.rest.api.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Postagem implements Serializable {
    private static final long serialVensionUID = 1L;

    public Postagem(){}

    public Postagem(int id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private int id;
    private String title;
    private String author;
    private String content;

    public int getId(){
        return this.id;
    }

    public void setTitle(String _title){
        this.title = _title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setAuthor(String _author){
        this.author = _author;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setContent(String _content){
        this.content = _content;
    }

    public String getContent(){
        return this.content;
    }


}
