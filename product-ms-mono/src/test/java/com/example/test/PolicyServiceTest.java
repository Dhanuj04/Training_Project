package com.example.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.entity.Policy;
import com.repository.PolicyRepository;
import com.service.PolicyService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PolicyServiceTest {
    @InjectMocks
    private PolicyService policyService;

    @Mock
    private PolicyRepository policyRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllPolicies() {
        // Mock the repository to return a list of policies
        List<Policy> policies = Arrays.asList(
            new Policy(101, "Policy 1","abc",1000.0,5,5,1),
            new Policy(102, "Policy 2","def",2000.0,1,2,2)
        );
        when(policyRepository.findAll()).thenReturn(policies);

        List<Policy> result = policyService.getAllPolicies();

        // Verify that the service method returns the expected policies
        assertEquals(2, result.size());
        assertEquals("Policy 1", result.get(0).getPolicy_name());
    }

    @Test
    void testGetPolicyById() {
        // Mock the repository to return a policy with ID 1
        when(policyRepository.findById(101L)).thenReturn(Optional.of(new Policy(101, "Policy 2","abc",1000.0,5,5,1)));

        Policy result = policyService.getPolicyById(101L);

        // Verify that the service method returns the expected policy
        assertEquals("Policy 2", result.getPolicy_name());
    }
    
    @Test
    void testSavePolicy() {
        // Create a sample policy
        Policy policyToSave = new Policy();
        policyToSave.setPolicy_id(101L);
        policyToSave.setPolicy_name("Test Policy");
        policyToSave.setPolicy_description("abc");
        policyToSave.setStandardPremium(200.0);
        policyToSave.setCoverageAmount(5);
        policyToSave.setTerm(5);
        policyToSave.setInsurance_id(1);

        // Mock the repository to return the saved policy
        when(policyRepository.save(policyToSave)).thenReturn(policyToSave);

        // Call the service method to save the policy
        Policy savedPolicy = policyService.savePolicy(policyToSave);

        // Verify that the policy was saved and returned correctly
        verify(policyRepository, times(1)).save(policyToSave);
        assertEquals("Test Policy", savedPolicy.getPolicy_name());
    }
    
    @Test
    void testUpdatePolicy() {
        // Create a sample policy with updated information
        Policy updatedPolicy = new Policy();
        //updatedPolicy.setPolicy_id(101L);
        updatedPolicy.setPolicy_name("Updated Policy");
        updatedPolicy.setPolicy_description("abc");
        updatedPolicy.setStandardPremium(250.0);
        updatedPolicy.setCoverageAmount(5);
        updatedPolicy.setTerm(5);

        // Mock the repository to return the existing policy and save the updated policy
        Policy existingPolicy = new Policy();
        existingPolicy.setPolicy_id(101L);
        existingPolicy.setPolicy_name("Test Policy");
        existingPolicy.setPolicy_description("abc");
        existingPolicy.setStandardPremium(200.0);
        existingPolicy.setCoverageAmount(5);
        existingPolicy.setTerm(5);
        existingPolicy.setInsurance_id(1);
        when(policyRepository.findById(101L)).thenReturn(Optional.of(existingPolicy));
        when(policyRepository.save(existingPolicy)).thenReturn(existingPolicy);

        // Call the service method to update the policy
        Policy result = policyService.updatePolicy(updatedPolicy,101L);

        // Verify that the repository's findById and save methods were called
        verify(policyRepository, times(1)).findById(101L);
        verify(policyRepository, times(1)).save(existingPolicy);

        // Verify that the updated policy was returned
        assertEquals("Updated Policy", result.getPolicy_name());
        assertEquals(250.0, result.getStandardPremium());
    }
    
    
    @Test
    void testDeletePolicy() {
        // Define a policy ID to delete
        long policyId = 101L;

        // Mock the repository to return a policy when findById is called
        Policy policyToDelete = new Policy();
        when(policyRepository.findById(policyId)).thenReturn(Optional.of(policyToDelete));

        // Call the service method to delete the policy
        policyService.deletePolicy(policyId);

        // Verify that the repository's findById and delete methods were called
        verify(policyRepository, times(1)).findById(policyId);
        verify(policyRepository, times(1)).delete(policyToDelete);
    }
    
    
}
