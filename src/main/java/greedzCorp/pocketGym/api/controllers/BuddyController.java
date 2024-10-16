package greedzCorp.pocketGym.api.controllers;


import greedzCorp.pocketGym.business.abstracts.CRUD.BuddyService;
import greedzCorp.pocketGym.business.requests.BuddyRequest;
import greedzCorp.pocketGym.core.utilities.results.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buddy")
public class BuddyController {
    private BuddyService buddyService;

    public BuddyController(BuddyService buddyService) {
        this.buddyService = buddyService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody BuddyRequest request) {
        return this.buddyService.add(request);
    }

    @PostMapping("/update")
    public Result update(@RequestBody BuddyRequest request) {
        return this.buddyService.update(request);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody BuddyRequest request) {
        return this.buddyService.delete(request);
    }
}
