package id.muhammadfaisal.kring.repo;

import id.muhammadfaisal.kring.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
    @Query(value = "SELECT * FROM m_store", nativeQuery = true)
    public List<StoreEntity> stores();

    @Query(value = "SELECT * FROM m_store WHERE id = :id", nativeQuery = true)
    public StoreEntity getStore(int id);
}
