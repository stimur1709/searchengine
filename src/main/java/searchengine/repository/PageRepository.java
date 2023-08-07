package searchengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import searchengine.model.Page;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {

    @Transactional
    @Modifying
    @Query("delete from Page p where p.siteId = ?1")
    void deleteBySiteId(Long siteId);

    @Transactional
    @Modifying
    @Query("delete from Page p where p.siteId in (?1)")
    void deleteByInSiteId(List<Long> siteId);

    long countBySiteId(Long siteId);

}
