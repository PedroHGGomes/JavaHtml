package webapp.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Ovni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Informe o local")
    private String local;

    @NotBlank(message = "Informe a descrição")
    private String descricao;

    @NotNull(message = "Informe a data")
    @DateTimeFormat(pattern = "yyyy-MM-dd") // casa com <input type="date">
    private LocalDate data;

    public Ovni() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
}


