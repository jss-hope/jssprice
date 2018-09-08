package com.jss.price.repository;

import com.jss.price.bo.Lunzhengfei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

public interface LunzhengfeiRepository extends JpaRepository<Lunzhengfei,Long> {
    @Query(value = "SELECT * FROM `lunzhengfei`WHERE project_id=?1 and item_order IS NOT null ORDER BY item_order",nativeQuery = true)
    public List<Lunzhengfei> listLzfByProjectId(Integer id);

    public List<Lunzhengfei> findByProjectId(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update lunzhengfei set s_renshu =:sRenshu where uuid = :id",nativeQuery = true)
    public  void updateByProject(@Param("id") Long id,
                                 @Param("sRenshu")Integer sRenshu);

    @Transactional
    @Modifying
    @Query(value = "update lunzhengfei set s_cishu =:sCishu where uuid = :id",nativeQuery = true)
    public  void updateCishu(@Param("id") Long id,
                                 @Param("sCishu")Integer sCishu);
}
