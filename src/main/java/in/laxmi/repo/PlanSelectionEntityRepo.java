package in.laxmi.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.laxmi.entity.PlanSelectionEntity;

public interface PlanSelectionEntityRepo extends JpaRepository<PlanSelectionEntity, Integer> {
@Query("from PlanSelectionEntity where caseNum=:caseNum")
	public PlanSelectionEntity findByCaseNum(Long caseNum);

}
