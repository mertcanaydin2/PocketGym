package greedzCorp.pocketGym.api.controllers;


import greedzCorp.pocketGym.business.abstracts.FindBuddyService;
import greedzCorp.pocketGym.business.requests.BuddyRequest;
import greedzCorp.pocketGym.business.requests.ExerciseRequest;
import greedzCorp.pocketGym.core.utilities.results.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/findBuddy")
public class FindBuddyController {
    private FindBuddyService findBuddyService;

    public FindBuddyController(FindBuddyService findBuddyService) {
        this.findBuddyService = findBuddyService;
    }

    @PostMapping("/findRandomBuddy")
    public Result findRandomBuddy(@RequestBody BuddyRequest request) {
        return this.findBuddyService.findRandomBuddy(request);
    }
}
