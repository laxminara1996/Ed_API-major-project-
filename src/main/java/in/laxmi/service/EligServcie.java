package in.laxmi.service;

import java.util.List;

import in.laxmi.binding.EdResponse;

public interface EligServcie {
public EdResponse determineEligibility(Long caseNum);
public boolean generateCo(Long caseNum);
}
