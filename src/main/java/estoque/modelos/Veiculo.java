package estoque.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // AQUI ESTÁ A MUDANÇA: Relacionamento de Banco de Dados
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    private String modelo;
    private Integer anoFabricacao;
    private String cor;
    private Double preco;
    private Integer quilometragem;
    private String status; 

    public Veiculo() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Getters e Setters atualizados para o objeto Marca
    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(Integer anoFabricacao) { this.anoFabricacao = anoFabricacao; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Integer getQuilometragem() { return quilometragem; }
    public void setQuilometragem(Integer quilometragem) { this.quilometragem = quilometragem; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}