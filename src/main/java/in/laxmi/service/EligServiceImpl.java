package in.laxmi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import in.laxmi.binding.EdResponse;
import in.laxmi.entity.EducationEntity;
import in.laxmi.entity.EligEntity;
import in.laxmi.entity.IncomeEntity;
import in.laxmi.entity.KidEntity;
import in.laxmi.entity.PlanEntity;
import in.laxmi.entity.PlanSelectionEntity;
import in.laxmi.repo.EducationEntityRepo;
import in.laxmi.repo.EligRepo;
import in.laxmi.repo.IncomeEntityRepo;
import in.laxmi.repo.KidEnityRepo;
import in.laxmi.repo.PlanEntityRepo;
import in.laxmi.repo.PlanSelectionEntityRepo;

public class EligServiceImpl implements EligServcie {
	@Autowired
	private PlanSelectionEntityRepo planSelRepo;
	@Autowired
	private PlanEntityRepo planRepo;
	@Autowired
	private IncomeEntityRepo incomeRepo;
	@Autowired
	private EducationEntityRepo educationRepo;
	@Autowired
	private KidEnityRepo kidRepo;
    private EligRepo eligRepo;
	public EdResponse determineEligibility(Long caseNum) {
		EdResponse response = new EdResponse();
		PlanSelectionEntity plansel = planSelRepo.findByCaseNum(caseNum);
		Integer planId = plansel.getPlanId();
		Optional<PlanEntity> planEntity = planRepo.findById(planId);

		PlanEntity planDet = planEntity.get();
		String planName = planDet.getPlanName();

		IncomeEntity incomeEntity = incomeRepo.findByCaseNum(caseNum);
		EducationEntity educationEntity = educationRepo.findByCaseNum(caseNum);
		KidEntity kidEntity = kidRepo.findByCaseNum(caseNum);
		
		 response.setPlanName(planName);
		 response.setCaseNum(caseNum);
         if("SNAP".equals(planName)) {
        	 Double salaryIncome = incomeEntity.getSalaryIncome();
        	 if(salaryIncome>300) {
        		 response.setPlanStatus("DN");
        		 response.setDenailReason("High salary Income");
        	 }else {
        		 response.setPlanStatus("AP");
        		 response.setBenefitAmt(350.00);
        		 response.setEligStartDate(LocalDate.now());
        	     response.setEligEndDate(LocalDate.now().plusMonths(6));
        	 }
        	 
         }else if("CCAP".equals(planName)) {
        	 
         }else if("MediCaid".equals(planName)) {
        	 
         }else if("Medicare".equals(planName)) {
        	 
         }else if("RIW".equals(planName)) {
        	 
         }
         EligEntity entity = new EligEntity();
         BeanUtils.copyProperties(response, entity);;
         eligRepo.save(entity);
		return response;
	}

	public boolean generateCo(Long caseNum) {
		// TODO Auto-generated method stub
		return false;
	}

}
