package estoque.controladores;

import estoque.modelos.Veiculo;
import estoque.repositorios.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @GetMapping
    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/buscar")
    public List<Veiculo> buscar(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String cor,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Integer anoFabricacao) {
        return repository.findAll().stream()
            .filter(v -> marca == null || marca.isBlank() ||
                    (v.getMarca() != null && v.getMarca().getNome().toLowerCase().contains(marca.toLowerCase())))
            .filter(v -> modelo == null || modelo.isBlank() ||
                    (v.getModelo() != null && v.getModelo().toLowerCase().contains(modelo.toLowerCase())))
            .filter(v -> cor == null || cor.isBlank() ||
                    (v.getCor() != null && v.getCor().toLowerCase().contains(cor.toLowerCase())))
            .filter(v -> status == null || status.isBlank() ||
                    (v.getStatus() != null && v.getStatus().equalsIgnoreCase(status)))
            .filter(v -> anoFabricacao == null ||
                    (v.getAnoFabricacao() != null && v.getAnoFabricacao().equals(anoFabricacao)))
            .collect(Collectors.toList());
    }

    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return repository.save(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoExistente = repository.findById(id);
        
        if(veiculoExistente.isPresent()) {
            Veiculo v = veiculoExistente.get();
            v.setPreco(veiculoAtualizado.getPreco());
            v.setQuilometragem(veiculoAtualizado.getQuilometragem());
            v.setStatus(veiculoAtualizado.getStatus());
            return ResponseEntity.ok(repository.save(v));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
