package in.laxmi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.laxmi.entity.EducationEntity;
import in.laxmi.entity.IncomeEntity;

public interface EducationEntityRepo extends JpaRepository<EducationEntity, Integer> {
	@Query("from EducationEntity where caseNum=:caseNum")
	public EducationEntity findByCaseNum(Long caseNum);
}
