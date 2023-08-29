package in.laxmi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.laxmi.entity.IncomeEntity;
import in.laxmi.entity.KidEntity;

public interface KidEnityRepo extends JpaRepository<KidEntity, Integer>{
	@Query("from KidEntity where caseNum=:caseNum")
	public KidEntity findByCaseNum(Long caseNum);
}
