package in.laxmi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.laxmi.entity.IncomeEntity;

public interface IncomeEntityRepo extends JpaRepository<IncomeEntity, Integer> {
	@Query("from IncomeEntity where caseNum=:caseNum")
	public IncomeEntity findByCaseNum(Long caseNum);
}
