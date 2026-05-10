package estoque.repositorios;

import estoque.modelos.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByMarcaNomeAndStatus(String nomeMarca, String status);
}