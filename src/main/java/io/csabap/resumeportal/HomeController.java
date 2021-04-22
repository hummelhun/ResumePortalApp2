package io.csabap.resumeportal;

import io.csabap.resumeportal.models.Job;
import io.csabap.resumeportal.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    UserProfileRepository userProfileRepository;

    @GetMapping("/")
    public String hello(){
        UserProfile profile1 = new UserProfile();
        profile1.setId(1);
        profile1.setDesignation("theoretical physicist");
        profile1.setUserName("einstein");
        profile1.setFirstName("Albert");
        profile1.setLastName("Einstein");
        profile1.setTheme(1);

        Job job1 = new Job();
        job1.setCompany("Company1");
        job1.setDesignation("Designation No1");
        job1.setId(1);
        job1.setStartDate(LocalDate.of(2020, 1, 1));
        job1.setEndDate(LocalDate.of(2021, 1, 1));

        Job job2 = new Job();
        job2.setCompany("Company 2");
        job2.setDesignation("Designation No2");
        job2.setId(2);
        job2.setStartDate(LocalDate.of(2021, 2, 1));
        job2.setEndDate(LocalDate.of(2022, 3, 1));

        profile1.setJobs(Arrays.asList(job1, job2));
        userProfileRepository.save(profile1);

        return "profile";
    }
    @GetMapping("/edit")
    public String edit(){
        return "Edit page";
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model){
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userId));

        model.addAttribute("userId", userId);
        UserProfile userProfile = userProfileOptional.get();
        model.addAttribute("userProfile", userProfile);
        System.out.println(userProfile.getJobs());

        return "profile-templates/"+userProfile.getTheme()+"/index";
    }
}
