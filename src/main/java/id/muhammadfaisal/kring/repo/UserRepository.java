package id.muhammadfaisal.kring.repo;

import id.muhammadfaisal.kring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Modifying
    @Query(value = "UPDATE m_user SET pin = :pin WHERE id = :userId", nativeQuery = true)
    public void createPin(String pin, int userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE m_user SET session = :session WHERE id = :userId", nativeQuery = true)
    public void updateSession(String session, long userId);

    @Query(value = "SELECT * FROM m_user WHERE pin = :pin AND id = :userId", nativeQuery = true)
    public BigInteger verifyPin(String pin, int userId);

    @Query(value = "SELECT * FROM m_user WHERE email = :identifier OR phone = :identifier", nativeQuery = true)
    public UserEntity findByIdentifier(String identifier);

    @Query(value = "SELECT * FROM m_user WHERE session = :session", nativeQuery = true)
    public UserEntity findBySession(String session);
}
